package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "funds")
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_id")
    private Long recId;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "amount", precision = 12, scale = 4)
    private BigDecimal amount;

    @Column(name = "tran_time")
    private LocalDateTime tranTime;

    @Column(name = "fund_manager_id")
    private Long fundManagerId;

    @Column(name = "fund_acc_balance", precision = 12, scale = 4)
    private BigDecimal fundAccBalance;

    @Column(name = "bank_acc_no")
    private String bankAccNo;

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTranTime() {
        return tranTime;
    }

    public void setTranTime(LocalDateTime tranTime) {
        this.tranTime = tranTime;
    }

    public Long getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Long fundManagerId) {
        this.fundManagerId = fundManagerId;
    }

    public BigDecimal getFundAccBalance() {
        return fundAccBalance;
    }

    public void setFundAccBalance(BigDecimal fundAccBalance) {
        this.fundAccBalance = fundAccBalance;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }
}
