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

    public Optional<Asset> getAssetBySymbol(String symbol) {
        return assetRepository.findById(symbol);
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public void deleteAsset(String symbol) {
        assetRepository.deleteById(symbol);
    }
}