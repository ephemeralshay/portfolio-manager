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

    public FundManager getFundManagerById(Long id) {
        Optional<FundManager> fundManager = fundManagerRepository.findById(id);
        return fundManager.orElse(null);
    }

    public FundManager saveFundManager(FundManager fundManager) {
        return fundManagerRepository.save(fundManager);
    }

    public FundManager updateFundManager(Long id, FundManager fundManagerDetails) {
        if (fundManagerRepository.existsById(id)) {
            fundManagerDetails.setFundManagerId(id);
            return fundManagerRepository.save(fundManagerDetails);
        } else {
            return null;
        }
    }

    public void deleteFundManager(Long id) {
        fundManagerRepository.deleteById(id);
    }
}
