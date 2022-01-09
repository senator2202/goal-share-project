package com.goalshare.project.goalsharerest.controller.exception;

import java.util.HashMap;
import java.util.Map;

public class BindingResultException extends RuntimeException {

    private final Map<String, String> errorMap = new HashMap<>();

    public void put(String key, String value) {
        errorMap.put(key, value);
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
