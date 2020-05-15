package com.example.count_test.methods;

import com.example.count_test.dto.ApiResponse;
import com.example.count_test.dto.CountDto;
import com.example.count_test.dto.Error;
import com.example.count_test.service.CountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountOperationRestMethod {

    private CountService countService;

    public CountOperationRestMethod(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/count/increment")
    public ApiResponse<CountDto> countIncrement(@RequestParam String name) {
        if (countService.isCountExist(name)) {
            CountDto countDto = countService.increment(name);
            return new ApiResponse<>(countDto, null);
        }

        return new ApiResponse<>(null, Error.count_not_fount);
    }

    @GetMapping("/count/sum")
    public ApiResponse<Long> countSum() {
        long sum = countService.countSum();
        return new ApiResponse<>(sum, null);
    }

    @GetMapping("/count/names")
    public ApiResponse<List<String>> countNames() {
        List<String> countNames = countService.countNames();
        return new ApiResponse<>(countNames, null);
    }
}
