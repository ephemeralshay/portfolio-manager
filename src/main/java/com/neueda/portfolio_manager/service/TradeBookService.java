package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.*;
import com.neueda.portfolio_manager.repository.FundBalanceHistoryRepository;
import com.neueda.portfolio_manager.repository.FundManagerRepository;
import com.neueda.portfolio_manager.repository.FundTranRepository;
import com.neueda.portfolio_manager.repository.TradeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradeBookService {

    @Autowired
    private TradeBookRepository tradeBookRepository;

    @Autowired
    private FundTranRepository fundTranRepository;

    @Autowired
    private FundBalanceHistoryRepository fundBalanceHistoryRepository;

    @Autowired
    private FundManagerRepository fundManagerRepository;

    public List<TradeBook> getAllTradeBooks() {
        return tradeBookRepository.findAll();
    }

    public Optional<TradeBook> getTradeBookById(Integer id) {
        return tradeBookRepository.findById(id);
    }

//    public TradeBook saveTradeBook(TradeBook tradeBook) {
//        return tradeBookRepository.save(tradeBook);
//    }

    public TradeProcessingResponse processTrades(List<TradeBook> trades) {
        List<String> successRecords = new ArrayList<>();
        List<String> failedRecords = new ArrayList<>();

        for (TradeBook trade : trades) {
            try {
                // Insert record in trade_book
                trade.setTranStatus('A'); // Set status to 'A'
                trade.setTranTime(LocalDateTime.now());
                tradeBookRepository.save(trade);

                // Retrieve the current balance from fund_managers table
                FundManager fundManager = fundManagerRepository.findById(trade.getFundManagerId())
                        .orElseThrow(() -> new RuntimeException("Fund Manager not found"));
                BigDecimal latestBalance = fundManager.getCurrentBalance(); // Get the current balance

                // Update balance based on trade type
                BigDecimal newBalance;
                char tranType;

                // Update balance based on trade type
                if (trade.getBuySell() == 'B') { // Buy
                    newBalance = latestBalance.subtract(trade.getTradeAmount());
                    tranType = 'd'; // Set to Debit
                } else { // Sell
                    newBalance = latestBalance.add(trade.getTradeAmount());
                    tranType = 'c'; // Set to Credit
                }

                // Insert record in fund_tran table
                FundTran fundTran = new FundTran();
                fundTran.setFundManagerId(trade.getFundManagerId());
                fundTran.setTranType(tranType);
                fundTran.setAmount(trade.getTradeAmount());
                fundTran.setTranTime(trade.getTranTime());
                fundTran.setFundAccBalance(newBalance);
                fundTranRepository.save(fundTran);

                // Update fund_balance_history table
                FundBalanceHistory balanceHistory = fundBalanceHistoryRepository.findByFundManagerIdAndBalanceDate(trade.getFundManagerId(), LocalDate.now())
                        .orElse(new FundBalanceHistory());

                balanceHistory.setFundManagerId(trade.getFundManagerId());
                balanceHistory.setBalanceDate(LocalDate.now());
                balanceHistory.setBalance(newBalance);
                fundBalanceHistoryRepository.save(balanceHistory);

                // Update the current balance in fund_managers table
                fundManager.setCurrentBalance(newBalance); // Update the balance
                fundManagerRepository.save(fundManager);

                successRecords.add("Trade ID " + trade.getTradeId() + " processed successfully.");
            } catch (Exception e) {
                failedRecords.add("Trade ID " + trade.getTradeId() + " failed: " + e.getMessage());
            }
        }
        // Return success and failure reports
        return new TradeProcessingResponse(successRecords, failedRecords);
    }
//    public void deleteTradeBook(Integer id) {
//        tradeBookRepository.deleteById(id);
//    }
}