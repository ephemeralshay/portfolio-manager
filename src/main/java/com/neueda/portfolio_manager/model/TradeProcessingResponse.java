package com.neueda.portfolio_manager.model;

import java.util.List;

public class TradeProcessingResponse {
    private List<String> successRecords;
    private List<String> failedRecords;

    // Constructors
    public TradeProcessingResponse() {}

    public TradeProcessingResponse(List<String> successRecords, List<String> failedRecords) {
        this.successRecords = successRecords;
        this.failedRecords = failedRecords;
    }

    // Getters and Setters
    public List<String> getSuccessRecords() {
        return successRecords;
    }

    public void setSuccessRecords(List<String> successRecords) {
        this.successRecords = successRecords;
    }

    public List<String> getFailedRecords() {
        return failedRecords;
    }

    public void setFailedRecords(List<String> failedRecords) {
        this.failedRecords = failedRecords;
    }
}
