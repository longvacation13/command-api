package com.main.api.service.impl;

import com.main.api.dto.TestDto;
import com.main.api.service.MergeSortService;
import org.springframework.stereotype.Service;

@Service
public class MergeMergeSortServiceImpl implements MergeSortService {

    @Override
    public TestDto MergeSort(String values) {
        TestDto responseData = new TestDto();
        responseData.setValues(values);
        return responseData;
    }
}
