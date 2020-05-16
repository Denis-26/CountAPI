package com.example.count_test.service;

import com.example.count_test.dto.CountDto;
import com.example.count_test.store.CountStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CountServiceImpl implements CountService {

    private CountStore countStore;

    public CountServiceImpl(CountStore countStore) {
        this.countStore = countStore;
    }

    @Override
    public CountDto getCount(String name) {
        return countStore.getCountByName(name);
    }

    @Override
    public CountDto createCount(String name) {
        CountDto countDto = new CountDto();
        countDto.setName(name);
        countDto.setAccumulator(0);
        countStore.saveCount(countDto);

        return countDto;
    }

    @Override
    public CountDto remove(String name) {
        return countStore.removeCountByName(name);
    }

    @Override
    public boolean isCountExist(String name) {
        return countStore.getCountByName(name) != null;
    }

    @Override
    public CountDto increment(String name) {
        Map<String, CountDto> countDtoMap = countStore.getCounts();
        countDtoMap.computeIfPresent(name, (key, value) -> {
           value.setAccumulator(value.getAccumulator() + 1);
           return value;
        });

        return countDtoMap.get(name);
    }

    @Override
    public long countSum() {
        Map<String, CountDto> countDtoMap = countStore.getCounts();
        return countDtoMap
                .keySet()
                .stream()
                .mapToInt((key) -> countDtoMap.get(key).getAccumulator())
                .sum();
    }

    @Override
    public List<String> countNames() {
        Map<String, CountDto> countDtoMap = countStore.getCounts();
        return new ArrayList<>(countDtoMap.keySet());
    }
}
