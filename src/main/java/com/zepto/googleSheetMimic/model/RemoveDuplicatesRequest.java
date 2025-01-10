package com.zepto.googleSheetMimic.model;

import java.util.List;

public class RemoveDuplicatesRequest {
    private List<List<String>> range;

    public List<List<String>> getRange() {
        return range;
    }

    public void setRange(List<List<String>> range) {
        this.range = range;
    }
}

