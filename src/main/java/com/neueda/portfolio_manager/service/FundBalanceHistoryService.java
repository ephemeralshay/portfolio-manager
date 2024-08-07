package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.FundBalanceHistory;
import com.neueda.portfolio_manager.repository.FundBalanceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundBalanceHistoryService {
    @Autowired
    private FundBalanceHistoryRepository fundBalanceHistoryRepository;

    public List<FundBalanceHistory> getAllFundBalanceHistories() {
        return fundBalanceHistoryRepository.findAll();
    }

    public FundBalanceHistory getFundBalanceHistoryById(Long id) {
        Optional<FundBalanceHistory> fundBalanceHistory = fundBalanceHistoryRepository.findById(id);
        return fundBalanceHistory.orElse(null);
    }

    public FundBalanceHistory saveFundBalanceHistory(FundBalanceHistory fundBalanceHistory) {
        return fundBalanceHistoryRepository.save(fundBalanceHistory);
    }

    public FundBalanceHistory updateFundBalanceHistory(Long id, FundBalanceHistory fundBalanceHistoryDetails) {
        if (fundBalanceHistoryRepository.existsById(id)) {
            fundBalanceHistoryDetails.setId(id);
            return fundBalanceHistoryRepository.save(fundBalanceHistoryDetails);
        } else {
            return null;
        }
    }

    public void deleteFundBalanceHistory(Long id) {
        fundBalanceHistoryRepository.deleteById(id);
    }


}
