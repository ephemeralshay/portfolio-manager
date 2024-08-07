package com.neueda.portfolio_manager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @Column(name = "symbol", length = 12)
    private String symbol;

    @Column(name = "asset_type", length = 3)
    private String assetType;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "closing_price", precision = 12, scale = 4)
    private BigDecimal closingPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }
}
