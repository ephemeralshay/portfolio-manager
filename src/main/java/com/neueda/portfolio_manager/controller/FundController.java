package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.Fund;
import com.neueda.portfolio_manager.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funds")
public class FundController {

    @Autowired
    private FundService fundService;

    @GetMapping
    public List<Fund> getAllFunds() {
        return fundService.getAllFunds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fund> getFundById(@PathVariable("id") Long id) {
        Fund fund = fundService.getFundById(id);
        if (fund != null) {
            return ResponseEntity.ok(fund);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Fund createFund(@RequestBody Fund fund) {
        return fundService.saveFund(fund);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fund> updateFund(@PathVariable("id") Long id, @RequestBody Fund fundDetails) {
        Fund updatedFund = fundService.updateFund(id, fundDetails);
        if (updatedFund != null) {
            return ResponseEntity.ok(updatedFund);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFund(@PathVariable("id") Long id) {
        fundService.deleteFund(id);
        return ResponseEntity.noContent().build();
    }
}
