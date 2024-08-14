package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fund_tran")
public class FundTran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_id")
    private Integer recId;

    @Column(name = "tran_type", length = 1, nullable = false)
    @NotNull
    private Character tranType;

    @Column(precision = 12, scale = 4, nullable = false)
    @NotNull
    private BigDecimal amount;

    @Column(name = "tran_time", nullable = false)
    @NotNull
    private LocalDateTime tranTime;

    @Column(name = "fund_manager_id")
    @NotNull
    private Integer fundManagerId;

    @Column(name = "fund_acc_balance", precision = 12, scale = 4)
    private BigDecimal fundAccBalance;

    @Column(name = "bank_acc_no", length = 50)
    private String bankAccNo;

    public FundTran() {
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Character getTranType() {
        return tranType;
    }

    public void setTranType(Character tranType) {
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

    public Integer getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Integer fundManagerId) {
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