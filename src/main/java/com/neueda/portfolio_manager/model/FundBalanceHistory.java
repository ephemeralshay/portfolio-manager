package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fund_balance_history")
public class FundBalanceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fund_manager_id", nullable = false)
    @NotNull
    private Integer fundManagerId;

    @Column(name = "balance_date", nullable = false)
    @NotNull
    private LocalDate balanceDate;

    @Column(name = "balance", precision = 12, scale = 4, nullable = false)
    @NotNull
    private BigDecimal balance;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Integer fundManagerId) {
        this.fundManagerId = fundManagerId;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
