package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.Asset;
import com.neueda.portfolio_manager.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Asset> getAssetBySymbol(@PathVariable String symbol) {
        Optional<Asset> asset = assetService.getAssetBySymbol(symbol);
        return asset.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset createdAsset = assetService.saveAsset(asset);
        return ResponseEntity.ok(createdAsset);
    }

    @PutMapping("/{symbol}")
    public ResponseEntity<Asset> updateAsset(@PathVariable String symbol, @RequestBody Asset asset) {
        if (assetService.getAssetBySymbol(symbol).isPresent()) {
            asset.setSymbol(symbol);
            Asset updatedAsset = assetService.saveAsset(asset);
            return ResponseEntity.ok(updatedAsset);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{symbol}")
    public ResponseEntity<Void> deleteAsset(@PathVariable String symbol) {
        if (assetService.getAssetBySymbol(symbol).isPresent()) {
            assetService.deleteAsset(symbol);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}