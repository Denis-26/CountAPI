package com.example.count_test.service;

import com.example.count_test.dto.CountDto;

import java.util.List;

public interface CountService {

    CountDto getCount(String name);

    CountDto createCount(String name);

    CountDto remove(String name);

    boolean isCountExist(String name);

    CountDto increment(String name);

    long countSum();

    List<String> countNames();

}
