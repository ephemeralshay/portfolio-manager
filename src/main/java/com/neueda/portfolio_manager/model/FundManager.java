package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fund_manager")
public class FundManager {
    @Id
    @Column(name = "fund_manager_id")
    private Long fundManagerId;

    @Column(name = "fm_name")
    private String fmName;

    @Column(name = "current_balance", precision = 12, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    public Long getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Long fundManagerId) {
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

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}
