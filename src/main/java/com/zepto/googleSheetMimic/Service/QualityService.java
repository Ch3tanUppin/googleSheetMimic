package com.zepto.googleSheetMimic.Service;



import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualityService {

    public List<List<String>> removeDuplicates(List<List<String>> range) {
        // Use a stream to remove duplicate rows based on content
        return range.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

