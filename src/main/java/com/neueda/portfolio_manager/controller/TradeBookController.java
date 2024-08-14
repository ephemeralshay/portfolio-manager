package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.TradeBook;
import com.neueda.portfolio_manager.model.TradeProcessingResponse;
import com.neueda.portfolio_manager.service.TradeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trade-books")
public class TradeBookController {

    @Autowired
    private TradeBookService tradeBookService;

    @GetMapping
    public List<TradeBook> getAllTradeBooks() {
        return tradeBookService.getAllTradeBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeBook> getTradeBookById(@PathVariable Integer id) {
        Optional<TradeBook> tradeBook = tradeBookService.getTradeBookById(id);
        return tradeBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<TradeBook> createTradeBook(@RequestBody TradeBook tradeBook) {
//        TradeBook createdTradeBook = tradeBookService.saveTradeBook(tradeBook);
//        return ResponseEntity.ok(createdTradeBook);
//    }

    @PostMapping("/process")
    public ResponseEntity<TradeProcessingResponse> processTrades(@Valid @RequestBody List<TradeBook> trades) {
        try {
            TradeProcessingResponse response = tradeBookService.processTrades(trades);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TradeBook> updateTradeBook(@PathVariable Integer id, @RequestBody TradeBook tradeBook) {
//        if (tradeBookService.getTradeBookById(id).isPresent()) {
//            tradeBook.setTradeId(id);
//            TradeBook updatedTradeBook = tradeBookService.saveTradeBook(tradeBook);
//            return ResponseEntity.ok(updatedTradeBook);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTradeBook(@PathVariable Integer id) {
//        if (tradeBookService.getTradeBookById(id).isPresent()) {
//            tradeBookService.deleteTradeBook(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}