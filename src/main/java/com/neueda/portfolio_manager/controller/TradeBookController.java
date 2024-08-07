package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.TradeBook;
import com.neueda.portfolio_manager.service.TradeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tradebooks")
public class TradeBookController {

    @Autowired
    private TradeBookService tradeBookService;

    @GetMapping
    public List<TradeBook> getAllTradeBooks() {
        return tradeBookService.getAllTradeBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeBook> getTradeBookById(@PathVariable("id") Long id) {
        TradeBook tradeBook = tradeBookService.getTradeBookById(id);
        if (tradeBook != null) {
            return ResponseEntity.ok(tradeBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TradeBook createTradeBook(@RequestBody TradeBook tradeBook) {
        return tradeBookService.saveTradeBook(tradeBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TradeBook> updateTradeBook(@PathVariable("id") Long id, @RequestBody TradeBook tradeBookDetails) {
        TradeBook updatedTradeBook = tradeBookService.updateTradeBook(id, tradeBookDetails);
        if (updatedTradeBook != null) {
            return ResponseEntity.ok(updatedTradeBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTradeBook(@PathVariable("id") Long id) {
        tradeBookService.deleteTradeBook(id);
        return ResponseEntity.noContent().build();
    }
}

