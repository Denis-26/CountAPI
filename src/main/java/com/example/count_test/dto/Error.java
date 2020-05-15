package com.example.count_test.dto;

public enum Error implements ApiError {

    count_not_fount("Счетчик не существует"),
    count_allready_exist("Счетчик уже создан");

    private String errorName;

    Error(String errorName) {
        this.errorName = errorName;
    }

    public String getError() {
        return this.errorName;
    }
}
