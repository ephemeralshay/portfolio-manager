package com.neueda.portfolio_manager.controller;

import com.neueda.portfolio_manager.model.Asset;
import com.neueda.portfolio_manager.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Asset> getAssetBySymbol(@PathVariable("symbol") String symbol) {
        Asset asset = assetService.getAssetById(symbol);
        if (asset != null) {
            return ResponseEntity.ok(asset);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.saveAsset(asset);
    }

    @PutMapping("/{symbol}")
    public ResponseEntity<Asset> updateAsset(@PathVariable("symbol") String symbol, @RequestBody Asset assetDetails) {
        Asset updatedAsset = assetService.updateAsset(symbol, assetDetails);
        if (updatedAsset != null) {
            return ResponseEntity.ok(updatedAsset);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{symbol}")
    public ResponseEntity<Void> deleteAsset(@PathVariable("symbol") String symbol) {
        assetService.deleteAsset(symbol);
        return ResponseEntity.noContent().build();
    }
}
