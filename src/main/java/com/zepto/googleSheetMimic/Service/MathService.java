package com.zepto.googleSheetMimic.Service;

import org.springframework.stereotype.Service;

import com.zepto.googleSheetMimic.model.CalculationRequest;
import com.zepto.googleSheetMimic.model.Cell;

import java.util.List;

@Service
public class MathService {

    public double performCalculation(CalculationRequest request) {
        List<Cell> cells = request.getCells();
        String function = request.getFunction().toUpperCase();

        switch (function) {
            case "SUM":
                return sum(cells);
            case "AVERAGE":
                return average(cells);
            case "MAX":
                return max(cells);
            case "MIN":
                return min(cells);
            case "COUNT":
                return count(cells);
            default:
                throw new IllegalArgumentException("Unsupported function: " + function);
        }
    }

    private double sum(List<Cell> cells) {
        return cells.stream()
                .mapToDouble(cell -> parseDoubleOrZero(cell.getValue()))
                .sum();
    }

    private double average(List<Cell> cells) {
        return sum(cells) / cells.size();
    }

    private double max(List<Cell> cells) {
        return cells.stream()
                .mapToDouble(cell -> parseDoubleOrZero(cell.getValue()))
                .max()
                .orElse(0);
    }

    private double min(List<Cell> cells) {
        return cells.stream()
                .mapToDouble(cell -> parseDoubleOrZero(cell.getValue()))
                .min()
                .orElse(0);
    }

    private long count(List<Cell> cells) {
        return cells.stream()
                .filter(cell -> isNumeric(cell.getValue()))
                .count();
    }

    private double parseDoubleOrZero(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0; // Treat non-numeric cells as zero
        }
    }

    private boolean isNumeric(String value) {
        if (value == null) return false;
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

