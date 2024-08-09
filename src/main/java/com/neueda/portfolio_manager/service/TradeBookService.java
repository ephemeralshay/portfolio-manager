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

    public Optional<TradeBook> getTradeBookById(Integer id) {
        return tradeBookRepository.findById(id);
    }

    public TradeBook saveTradeBook(TradeBook tradeBook) {
        return tradeBookRepository.save(tradeBook);
    }

    public void deleteTradeBook(Integer id) {
        tradeBookRepository.deleteById(id);
    }
}