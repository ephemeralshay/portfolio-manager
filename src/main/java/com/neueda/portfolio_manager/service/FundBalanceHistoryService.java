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

    public Optional<FundBalanceHistory> getFundBalanceHistoryById(Integer id) {
        return fundBalanceHistoryRepository.findById(id);
    }

    public FundBalanceHistory saveFundBalanceHistory(FundBalanceHistory fundBalanceHistory) {
        return fundBalanceHistoryRepository.save(fundBalanceHistory);
    }

//    public void deleteFundBalanceHistory(Integer id) {
//        fundBalanceHistoryRepository.deleteById(id);
//    }
}