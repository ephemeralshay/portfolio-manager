package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.Fund;
import com.neueda.portfolio_manager.repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FundService {
    @Autowired
    private FundRepository fundRepository;

    public List<Fund> getAllFunds() {
        return fundRepository.findAll();
    }

    public Fund getFundById(Long id) {
        Optional<Fund> fund = fundRepository.findById(id);
        return fund.orElse(null);
    }

    public Fund saveFund(Fund fund) {
        return fundRepository.save(fund);
    }

    public Fund updateFund(Long id, Fund fundDetails) {
        if (fundRepository.existsById(id)) {
            fundDetails.setRecId(id);
            return fundRepository.save(fundDetails);
        } else {
            return null;
        }
    }

    public void deleteFund(Long id) {
        fundRepository.deleteById(id);
    }
}
