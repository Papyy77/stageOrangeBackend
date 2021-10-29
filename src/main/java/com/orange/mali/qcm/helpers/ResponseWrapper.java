package com.orange.mali.qcm.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper {
    private String error = null;
    private int code = 400;
    private Object data = null;
    public ResponseWrapper(String error, Object data) {
        this.error = error;
        if(data instanceof  String || data instanceof Integer || data instanceof Double || data instanceof Long || data instanceof Float || data instanceof Boolean) {
            //convert to Map
            HashMap<String, Object> tmp = new HashMap<>();
            tmp.put("message", data);
            data = tmp;
        }
        this.data = data;
    }

    public boolean hasError() {
        return getError() != null;
    }
    public static ResponseWrapper of(Object data) {
        return new ResponseWrapper(null, data);
    }

    public static ResponseWrapper success(Object data) {
        return new ResponseWrapper(null, data);
    }

    public static ResponseWrapper error(String error) {
        return new ResponseWrapper(error, null);
    }
    public static ResponseWrapper error(String error, int code) {
        return new ResponseWrapper(error, code, null);
    }

    public static final ResponseWrapper SERVICE_UNAIVAILABLE_ERROR = ResponseWrapper.error("Service temporaiement indisponible. Merci de réessayer ulterieurement", 500);
    public static final ResponseWrapper INTERNAL_ERROR = ResponseWrapper.error("Erreur interne du service. Merci de réessayer ulterieurement", 500);
}

