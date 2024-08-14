package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.FundTran;
import com.neueda.portfolio_manager.service.FundTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<FundTran> getTransaction(@PathVariable Integer id) {
        Optional<FundTran> fundTran = fundTranService.getFundTranById(id);
        return fundTran.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create-transaction")
    public ResponseEntity<FundTran> createTransaction(@RequestBody FundTran fundTran) {
        try {
            FundTran savedTransaction = fundTranService.saveTransaction(fundTran);
            return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FundTran> updateTransaction(@PathVariable Integer id, @RequestBody FundTran fundTran) {
//        if (fundTranService.getFundTranById(id).isPresent()) {
//            fundTran.setRecId(id);
//            FundTran updatedFundTran = fundTranService.saveTransaction(fundTran);
//            return ResponseEntity.ok(updatedFundTran);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
//        if (fundTranService.getFundTranById(id).isPresent()) {
//            fundTranService.deleteFundTran(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}