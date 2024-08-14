package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.FundManager;
import com.neueda.portfolio_manager.service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund-managers")
public class FundManagerController {

    @Autowired
    private FundManagerService fundManagerService;

    @GetMapping
    public List<FundManager> getAllFundManagers() {
        return fundManagerService.getAllFundManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundManager> getFundManagerById(@PathVariable Integer id) {
        Optional<FundManager> fundManager = fundManagerService.getFundManagerById(id);
        return fundManager.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FundManager> createFundManager(@RequestBody FundManager fundManager) {
        FundManager createdFundManager = fundManagerService.saveFundManager(fundManager);
        return ResponseEntity.ok(createdFundManager);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FundManager> updateFundManager(@PathVariable Integer id, @RequestBody FundManager fundManager) {
//        if (fundManagerService.getFundManagerById(id).isPresent()) {
//            fundManager.setFundManagerId(id);
//            FundManager updatedFundManager = fundManagerService.saveFundManager(fundManager);
//            return ResponseEntity.ok(updatedFundManager);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFundManager(@PathVariable Integer id) {
//        if (fundManagerService.getFundManagerById(id).isPresent()) {
//            fundManagerService.deleteFundManager(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}