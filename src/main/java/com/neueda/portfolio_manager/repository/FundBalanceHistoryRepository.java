package com.neueda.portfolio_manager.repository;

import com.neueda.portfolio_manager.model.FundBalanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundBalanceHistoryRepository extends JpaRepository<FundBalanceHistory, Integer> {
}
