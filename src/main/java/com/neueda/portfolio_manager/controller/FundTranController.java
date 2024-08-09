package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.FundTran;
import com.neueda.portfolio_manager.service.FundTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund-transactions")
public class FundTranController {

    @Autowired
    private FundTranService fundTranService;

    @GetMapping
    public List<FundTran> getAllFundTrans() {
        return fundTranService.getAllFundTrans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundTran> getFundTranById(@PathVariable Integer id) {
        Optional<FundTran> fundTran = fundTranService.getFundTranById(id);
        return fundTran.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FundTran> createFundTran(@RequestBody FundTran fundTran) {
        FundTran createdFundTran = fundTranService.saveFundTran(fundTran);
        return ResponseEntity.ok(createdFundTran);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FundTran> updateFundTran(@PathVariable Integer id, @RequestBody FundTran fundTran) {
        if (fundTranService.getFundTranById(id).isPresent()) {
            fundTran.setRecId(id);
            FundTran updatedFundTran = fundTranService.saveFundTran(fundTran);
            return ResponseEntity.ok(updatedFundTran);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFundTran(@PathVariable Integer id) {
        if (fundTranService.getFundTranById(id).isPresent()) {
            fundTranService.deleteFundTran(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}