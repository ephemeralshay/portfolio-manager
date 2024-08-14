package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.FundBalanceHistory;
import com.neueda.portfolio_manager.model.FundManager;
import com.neueda.portfolio_manager.model.FundTran;
import com.neueda.portfolio_manager.repository.FundBalanceHistoryRepository;
import com.neueda.portfolio_manager.repository.FundManagerRepository;
import com.neueda.portfolio_manager.repository.FundTranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FundTranService {

    @Autowired
    private FundTranRepository fundTranRepository;

    @Autowired
    private FundBalanceHistoryRepository fundBalanceHistoryRepository;

    @Autowired
    private FundManagerRepository fundManagerRepository;

    public List<FundTran> getAllFundTrans() {
        return fundTranRepository.findAll();
    }

    public Optional<FundTran> getFundTranById(Integer id) {
        return fundTranRepository.findById(id);
    }

    public FundTran saveTransaction(FundTran fundTran) {

        // Retrieve the current fund_acc_balance from fund_managers table
        FundManager fundManager = fundManagerRepository.findById(fundTran.getFundManagerId())
                .orElseThrow(() -> new RuntimeException("Fund Manager not found"));
        BigDecimal currentBalance = fundManager.getCurrentBalance();

        // Step 2: Update balance based on the transaction type
        BigDecimal updatedBalance = (fundTran.getTranType() == 'd')
                ? currentBalance.subtract(fundTran.getAmount())
                : currentBalance.add(fundTran.getAmount());
        fundTran.setFundAccBalance(updatedBalance);

        // Step 3: Save the transaction record
        fundTranRepository.save(fundTran);

        // Step 4: Update fund_balance_history table
        FundBalanceHistory balanceHistory = fundBalanceHistoryRepository.findByFundManagerIdAndBalanceDate(fundTran.getFundManagerId(), LocalDate.now())
                .orElse(new FundBalanceHistory());

        balanceHistory.setFundManagerId(fundTran.getFundManagerId());
        balanceHistory.setBalanceDate(LocalDate.now());
        balanceHistory.setBalance(updatedBalance);

        // Save or update the balance history record
        fundBalanceHistoryRepository.save(balanceHistory);

        // Update the fund manager's current balance
        fundManager.setCurrentBalance(updatedBalance);
        fundManagerRepository.save(fundManager);

        return fundTran;
    }

//    public void deleteFundTran(Integer id) {
//        fundTranRepository.deleteById(id);
//    }
}