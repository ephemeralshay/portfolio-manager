package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fund_balance_history")
public class FundBalanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fund_manager_id")
    private Long fundManagerId;

    @Column(name = "balance_date")
    private LocalDate balanceDate;

    @Column(name = "balance", precision = 12, scale = 4)
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Long fundManagerId) {
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
