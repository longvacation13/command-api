package com.api.test.service.impl;

import com.api.test.dto.TestDto;
import com.api.test.service.MergeSortService;
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
