package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.FundBalanceHistory;
import com.neueda.portfolio_manager.service.FundBalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund-balance-histories")
public class FundBalanceHistoryController {

    @Autowired
    private FundBalanceHistoryService fundBalanceHistoryService;

    @GetMapping
    public List<FundBalanceHistory> getAllFundBalanceHistories() {
        return fundBalanceHistoryService.getAllFundBalanceHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundBalanceHistory> getFundBalanceHistoryById(@PathVariable Integer id) {
        Optional<FundBalanceHistory> fundBalanceHistory = fundBalanceHistoryService.getFundBalanceHistoryById(id);
        return fundBalanceHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FundBalanceHistory> createFundBalanceHistory(@RequestBody FundBalanceHistory fundBalanceHistory) {
        FundBalanceHistory createdFundBalanceHistory = fundBalanceHistoryService.saveFundBalanceHistory(fundBalanceHistory);
        return ResponseEntity.ok(createdFundBalanceHistory);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FundBalanceHistory> updateFundBalanceHistory(@PathVariable Integer id, @RequestBody FundBalanceHistory fundBalanceHistory) {
//        if (fundBalanceHistoryService.getFundBalanceHistoryById(id).isPresent()) {
//            fundBalanceHistory.setId(id);
//            FundBalanceHistory updatedFundBalanceHistory = fundBalanceHistoryService.saveFundBalanceHistory(fundBalanceHistory);
//            return ResponseEntity.ok(updatedFundBalanceHistory);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFundBalanceHistory(@PathVariable Integer id) {
//        if (fundBalanceHistoryService.getFundBalanceHistoryById(id).isPresent()) {
//            fundBalanceHistoryService.deleteFundBalanceHistory(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}