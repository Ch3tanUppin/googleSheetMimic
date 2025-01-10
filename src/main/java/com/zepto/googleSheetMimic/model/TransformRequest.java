package com.zepto.googleSheetMimic.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransformRequest {
    private String function; // e.g., TRIM, UPPER, LOWER, FIND_AND_REPLACE
    private List<String> cells; // List of cell values to transform
    private String find;        // Used for FIND_AND_REPLACE
    private String replace;     // Used for FIND_AND_REPLACE

    // Getters and Setters
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<String> getCells() {
        return cells;
    }

    public void setCells(List<String> cells) {
        this.cells = cells;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }
}

