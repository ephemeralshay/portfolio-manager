package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.FundTran;
import com.neueda.portfolio_manager.repository.FundTranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundTranService {

    @Autowired
    private FundTranRepository fundTranRepository;

    public List<FundTran> getAllFundTrans() {
        return fundTranRepository.findAll();
    }

    public Optional<FundTran> getFundTranById(Integer id) {
        return fundTranRepository.findById(id);
    }

    public FundTran saveFundTran(FundTran fundTran) {
        return fundTranRepository.save(fundTran);
    }

    public void deleteFundTran(Integer id) {
        fundTranRepository.deleteById(id);
    }
}