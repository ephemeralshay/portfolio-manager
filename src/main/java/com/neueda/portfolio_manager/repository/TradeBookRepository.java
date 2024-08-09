package com.neueda.portfolio_manager.repository;

import com.neueda.portfolio_manager.model.TradeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeBookRepository extends JpaRepository<TradeBook, Integer> {
}