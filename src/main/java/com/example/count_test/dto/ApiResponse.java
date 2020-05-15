package com.example.count_test.dto;

public class ApiResponse<T> extends AbstractApiResponse {

    private T data;

    public ApiResponse(T data, ApiError error) {
        setError(error);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
