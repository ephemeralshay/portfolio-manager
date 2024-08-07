package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.FundBalanceHistory;
import com.neueda.portfolio_manager.service.FundBalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fundbalancehistories")
public class FundBalanceHistoryController {

    @Autowired
    private FundBalanceHistoryService fundBalanceHistoryService;

    @GetMapping
    public List<FundBalanceHistory> getAllFundBalanceHistories() {
        return fundBalanceHistoryService.getAllFundBalanceHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundBalanceHistory> getFundBalanceHistoryById(@PathVariable("id") Long id) {
        FundBalanceHistory fundBalanceHistory = fundBalanceHistoryService.getFundBalanceHistoryById(id);
        if (fundBalanceHistory != null) {
            return ResponseEntity.ok(fundBalanceHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FundBalanceHistory createFundBalanceHistory(@RequestBody FundBalanceHistory fundBalanceHistory) {
        return fundBalanceHistoryService.saveFundBalanceHistory(fundBalanceHistory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FundBalanceHistory> updateFundBalanceHistory(@PathVariable("id") Long id, @RequestBody FundBalanceHistory fundBalanceHistoryDetails) {
        FundBalanceHistory updatedFundBalanceHistory = fundBalanceHistoryService.updateFundBalanceHistory(id, fundBalanceHistoryDetails);
        if (updatedFundBalanceHistory != null) {
            return ResponseEntity.ok(updatedFundBalanceHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFundBalanceHistory(@PathVariable("id") Long id) {
        fundBalanceHistoryService.deleteFundBalanceHistory(id);
        return ResponseEntity.noContent().build();
    }
}