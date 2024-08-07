package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.FundManager;
import com.neueda.portfolio_manager.service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fundmanagers")
public class FundManagerController {

    @Autowired
    private FundManagerService fundManagerService;

    @GetMapping
    public List<FundManager> getAllFundManagers() {
        return fundManagerService.getAllFundManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundManager> getFundManagerById(@PathVariable("id") Long id) {
        FundManager fundManager = fundManagerService.getFundManagerById(id);
        if (fundManager != null) {
            return ResponseEntity.ok(fundManager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FundManager createFundManager(@RequestBody FundManager fundManager) {
        return fundManagerService.saveFundManager(fundManager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FundManager> updateFundManager(@PathVariable("id") Long id, @RequestBody FundManager fundManagerDetails) {
        FundManager updatedFundManager = fundManagerService.updateFundManager(id, fundManagerDetails);
        if (updatedFundManager != null) {
            return ResponseEntity.ok(updatedFundManager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFundManager(@PathVariable("id") Long id) {
        fundManagerService.deleteFundManager(id);
        return ResponseEntity.noContent().build();
    }
}
