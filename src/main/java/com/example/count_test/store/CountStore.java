package com.example.count_test.store;

import com.example.count_test.dto.CountDto;

import java.util.Map;

public interface CountStore {

    void saveCount(CountDto countDto);

    CountDto getCountByName(String name);

    CountDto removeCountByName(String name);

    Map<String, CountDto> getCounts();
}
