package com.neueda.portfolio_manager.service;

import com.neueda.portfolio_manager.model.Asset;
import com.neueda.portfolio_manager.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(String symbol) {
        Optional<Asset> asset = assetRepository.findById(symbol);
        return asset.orElse(null);
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAsset(String symbol, Asset assetDetails) {
        if (assetRepository.existsById(symbol)) {
            assetDetails.setSymbol(symbol);
            return assetRepository.save(assetDetails);
        } else {
            return null;
        }
    }

    public void deleteAsset(String symbol) {
        assetRepository.deleteById(symbol);
    }
}
