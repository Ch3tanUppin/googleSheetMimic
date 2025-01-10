package com.zepto.googleSheetMimic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zepto.googleSheetMimic.Service.MathService;
import com.zepto.googleSheetMimic.Service.QualityService;
import com.zepto.googleSheetMimic.Service.TransformService;
import com.zepto.googleSheetMimic.model.CalculationRequest;
import com.zepto.googleSheetMimic.model.RemoveDuplicatesRequest;
import com.zepto.googleSheetMimic.model.TransformRequest;

@RestController
@RequestMapping("/api/sheets")
public class SheetsController {

    @Autowired
    private MathService mathService;
    @Autowired
    private QualityService qualityService;
    @Autowired
    private TransformService transformService;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody CalculationRequest request) {
        try {
            double result = mathService.performCalculation(request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/quality/remove-duplicates")
    public ResponseEntity<List<List<String>>> removeDuplicates(@RequestBody RemoveDuplicatesRequest request) {
        List<List<String>> result = qualityService.removeDuplicates(request.getRange());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/text/transform")
    public ResponseEntity<List<String>> transform(@RequestBody TransformRequest request) {
        try {
            List<String> result = transformService.transform(request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
