package com.orange.mali.qcm.helpers;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHelper {
    public static ResponseEntity error(String message) {
        Map<String, Object> err = new HashMap<>();
        err.put("message", message);
        err.put("status", "400");
        return ResponseEntity.status(200).body(err);
    }

    public static ResponseEntity success(Object responseObj) {
        Map<String, Object> r = new HashMap<>();
        r.put("data", responseObj);
        r.put("status", "200");
        return ResponseEntity.ok(r);
    }

    public static ResponseEntity error(String message, int code) {
        Map<String, Object> err = new HashMap<>();
        err.put("message", message);
        err.put("status", code + "");
        return ResponseEntity.status(200).body(err);
    }

    public static ResponseEntity respondFromWrapper(ResponseWrapper wrapper) {
        if (wrapper == null) {
            return ResponseHelper.error("Internal error", 500);
        }
        if (wrapper.getError() != null) {
            //error occured
            return ResponseHelper.error(wrapper.getError(), wrapper.getCode());
        }
        return ResponseHelper.success(wrapper.getData());
    }
}
