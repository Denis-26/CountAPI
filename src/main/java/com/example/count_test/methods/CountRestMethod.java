package com.example.count_test.methods;

import com.example.count_test.dto.ApiResponse;
import com.example.count_test.dto.CountDto;
import com.example.count_test.dto.Error;
import com.example.count_test.service.CountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CountRestMethod {

    private CountService countService;

    public CountRestMethod(CountService countService) {
        this.countService = countService;
    }

    @PostMapping("/count/create")
    public ApiResponse<CountDto> createCount(@RequestParam String name) {
        boolean countExist = countService.isCountExist(name);
        if (!countExist) {
            CountDto countDto = countService.createCount(name);
            return new ApiResponse<>(countDto, null);
        }

        return new ApiResponse<>(null, Error.count_allready_exist);
    }

    @GetMapping("/count/get")
    public ApiResponse<CountDto> getCount(@RequestParam String name) {
        CountDto countDto = countService.getCount(name);
        if (countDto != null) {
            return new ApiResponse<>(countDto, null);
        }

        return new ApiResponse<>(null, Error.count_not_fount);
    }

    @PostMapping("/count/remove")
    public ApiResponse<CountDto> countRemove(@RequestParam String name) {
        if (countService.isCountExist(name)) {
            CountDto countDto = countService.remove(name);
            return new ApiResponse<>(countDto, null);
        }

        return new ApiResponse<>(null, Error.count_not_fount);
    }


}
