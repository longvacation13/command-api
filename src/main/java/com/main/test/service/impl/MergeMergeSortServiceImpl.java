package com.main.test.service.impl;

import com.main.test.dto.TestDto;
import com.main.test.service.MergeSortService;
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
