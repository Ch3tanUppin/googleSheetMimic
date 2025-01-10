package com.zepto.googleSheetMimic.Service;


import org.springframework.stereotype.Service;

import com.zepto.googleSheetMimic.model.TransformRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransformService {

    public List<String> transform(TransformRequest request) {
        String function = request.getFunction().toUpperCase();
        List<String> cells = request.getCells();

        switch (function) {
            case "TRIM":
                return cells.stream().map(String::trim).collect(Collectors.toList());
            case "UPPER":
                return cells.stream().map(String::toUpperCase).collect(Collectors.toList());
            case "LOWER":
                return cells.stream().map(String::toLowerCase).collect(Collectors.toList());
            case "FIND_AND_REPLACE":
                String find = request.getFind();
                String replace = request.getReplace();
                return cells.stream()
                        .map(cell -> cell.replace(find, replace))
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unsupported function: " + function);
        }
    }
}

