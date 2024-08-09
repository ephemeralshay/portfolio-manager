package com.neueda.portfolio_manager.repository;

import com.neueda.portfolio_manager.model.FundManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundManagerRepository extends JpaRepository<FundManager, Integer> {
}
