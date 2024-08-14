package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trade_book")
public class TradeBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private Integer tradeId;

    @Column(name = "asset_id", nullable = false)
    @NotNull
    private String assetId;

    @Column(name = "asset_price", precision = 12, scale = 4, nullable = false)
    @NotNull
    private BigDecimal assetPrice;

    @Column(nullable = false)
    @NotNull
    private Integer quantity;

    @Column(name = "trade_amount", precision = 12, scale = 4, nullable = false)
    @NotNull
    private BigDecimal tradeAmount;

    @Column(name = "buy_sell", length = 1, nullable = false)
    @NotNull
    private Character buySell;

    @Column(name = "tran_time", nullable = false)
    private LocalDateTime tranTime;

    @Column(name = "fund_manager_id", nullable = false)
    @NotNull
    private Integer fundManagerId;

    @Column(name = "tran_status", length = 1, nullable = false)
    @NotNull
    private Character tranStatus;

    // Getters and Setters

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getFundManagerId() {
        return fundManagerId;
    }

    public void setFundManagerId(Integer fundManagerId) {
        this.fundManagerId = fundManagerId;
    }

    public BigDecimal getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(BigDecimal assetPrice) {
        this.assetPrice = assetPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Character getBuySell() {
        return buySell;
    }

    public void setBuySell(Character buySell) {
        this.buySell = buySell;
    }

    public Character getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(Character tranStatus) {
        this.tranStatus = tranStatus;
    }

    public LocalDateTime getTranTime() {
        return tranTime;
    }

    public void setTranTime(LocalDateTime tranTime) {
        this.tranTime = tranTime;
    }

}
