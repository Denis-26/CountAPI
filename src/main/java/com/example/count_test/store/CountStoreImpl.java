package com.example.count_test.store;

import com.example.count_test.dto.CountDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CountStoreImpl implements CountStore {

    private Map<String, CountDto> counts;

    public CountStoreImpl() {
        this.counts = new HashMap<>();
    }

    @Override
    public void saveCount(CountDto countDto) {
        counts.put(countDto.getName(), countDto);
    }

    @Override
    public CountDto getCountByName(String name) {
        return counts.get(name);
    }

    @Override
    public CountDto removeCountByName(String name) {
        return counts.remove(name);
    }

    @Override
    public Map<String, CountDto> getCounts() {
        return counts;
    }
}
