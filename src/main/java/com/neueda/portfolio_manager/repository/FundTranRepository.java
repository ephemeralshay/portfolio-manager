package com.neueda.portfolio_manager.repository;

import com.neueda.portfolio_manager.model.FundTran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTranRepository extends JpaRepository<FundTran, Integer> {
}