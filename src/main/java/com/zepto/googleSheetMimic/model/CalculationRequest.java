package com.zepto.googleSheetMimic.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationRequest {
    private String function; // e.g., SUM, AVERAGE
    private List<Cell> cells; // List of cells to operate on

}
