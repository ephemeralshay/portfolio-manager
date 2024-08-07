package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.TradeBook;
import com.neueda.portfolio_manager.repository.TradeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeBookService {
    @Autowired
    private TradeBookRepository tradeBookRepository;

    public List<TradeBook> getAllTradeBooks() {
        return tradeBookRepository.findAll();
    }

    public TradeBook getTradeBookById(Long id) {
        Optional<TradeBook> tradeBook = tradeBookRepository.findById(id);
        return tradeBook.orElse(null);
    }

    public TradeBook saveTradeBook(TradeBook tradeBook) {
        return tradeBookRepository.save(tradeBook);
    }

    public TradeBook updateTradeBook(Long id, TradeBook tradeBookDetails) {
        if (tradeBookRepository.existsById(id)) {
            tradeBookDetails.setTradeId(id);
            return tradeBookRepository.save(tradeBookDetails);
        } else {
            return null;
        }
    }

    public void deleteTradeBook(Long id) {
        tradeBookRepository.deleteById(id);
    }
}