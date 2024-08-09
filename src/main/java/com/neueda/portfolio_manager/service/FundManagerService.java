package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.FundManager;
import com.neueda.portfolio_manager.repository.FundManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundManagerService {

    @Autowired
    private FundManagerRepository fundManagerRepository;

    public List<FundManager> getAllFundManagers() {
        return fundManagerRepository.findAll();
    }

    public Optional<FundManager> getFundManagerById(Integer id) {
        return fundManagerRepository.findById(id);
    }

    public FundManager saveFundManager(FundManager fundManager) {
        return fundManagerRepository.save(fundManager);
    }

    public void deleteFundManager(Integer id) {
        fundManagerRepository.deleteById(id);
    }
}