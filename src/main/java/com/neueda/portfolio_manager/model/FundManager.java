package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fund_manager")
public class FundManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fund_manager_id")
    private Integer fundManagerId;

    @Column(length = 100, nullable = false)
    @NotNull
    private String fmName;

    @Column(precision = 12, scale = 4, nullable = false)
    @NotNull
    private BigDecimal currentBalance;

    @Column(name = "last_updated", nullable = false)
    @NotNull
    private LocalDateTime lastUpdated;

    // Getters and Setters

    public Integer getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Integer fundManagerId) {
        this.fundManagerId = fundManagerId;
    }

    public String getFmName() {
        return fmName;
    }

    public void setFmName(String fmName) {
        this.fmName = fmName;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
