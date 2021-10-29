package com.orange.mali.qcm.helpers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Http {

    private Long timeout = 600L;

    private String baseUrl;
    private String basicAuth;

    private RestTemplate restTemplate;
    public Http(String baseUrl) {
        this.baseUrl = baseUrl;
        restTemplate = newSecuredRestTemplate();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public ResponseEntity<String> doHttpPost(String endPoint, String req) {
        return doHttpPost(endPoint, req, null);
    }

    public ResponseEntity<String> doHttpPost(String endPoint, String req, String token) {
        String url = endPoint != null ? baseUrl + "/" + endPoint : baseUrl;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        if (token != null) {
            headers.add("Authorization", "Bearer " + token);
        }
        if (basicAuth != null) {
            headers.add("Authorization", "Basic " + basicAuth);
        }
        HttpEntity<String> request = new HttpEntity<>(req, headers);
        return perform(url, HttpMethod.POST, request);
    }

    public ResponseEntity<String> doHttpPostWithHeader(String endPoint, String req, HttpHeaders headers) {
        String url = endPoint != null ? baseUrl + "/" + endPoint : baseUrl;
        HttpEntity<String> request = new HttpEntity<>(req, headers);
        return perform(url, HttpMethod.POST, request);
    }

    public ResponseEntity<String> doHttpGet(String endPoint) {
        return doHttpGet(endPoint, null);
    }

    public ResponseEntity<String> doHttpGet(String endPoint, String token) {
        String url = endPoint != null ? baseUrl + "/" + endPoint : baseUrl;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        if (token != null) {
            headers.add("Authorization", "Bearer " + token);
        }
        if (basicAuth != null) {
            headers.add("Authorization", "Basic " + basicAuth);
        }
        HttpEntity<String> request = new HttpEntity<>(headers);
        return perform(url, HttpMethod.GET, request);
    }

    public ResponseEntity<String> doHttpGetWithHeader(String endPoint, HttpHeaders headers) {
        String url = endPoint != null ? baseUrl + "/" + endPoint : baseUrl;

        HttpEntity<String> request = new HttpEntity<>(headers);
        return perform(url, HttpMethod.GET, request);
    }
    public ResponseEntity<String> perform(String url, HttpMethod method, HttpEntity<?> request) {
        try {
            return restTemplate.exchange(url, method, request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private RestTemplate newSecuredRestTemplate() {
        return new RestTemplate();
    }

    private KeyStore keyStore(String file, char[] password) throws Exception {
        System.out.println("FILE: " + file);
        KeyStore keyStore = KeyStore.getInstance("JKS");
        File key = ResourceUtils.getFile(file);
        try (InputStream in = new FileInputStream(key)) {
            keyStore.load(in, password);
        }
        return keyStore;
    }

    private KeyStore keyStore(char[] password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        return keyStore;
    }

    public static Map<String, Object> toMap(String str) {
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
        };
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(str, typeRef);
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    /**
     * Decodes the passed UTF-8 String using an algorithm that's compatible with
     * JavaScript's <code>decodeURIComponent</code> function. Returns
     * <code>null</code> if the String is <code>null</code>.
     *
     * @param s The UTF-8 encoded String to be decoded
     * @return the decoded String
     */
    public static String decodeURIComponent(String s) {
        if (s == null) {
            return null;
        }

        String result = null;

        try {
            result = URLDecoder.decode(s, "UTF-8");
        }

        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    /**
     * Encodes the passed String as UTF-8 using an algorithm that's compatible
     * with JavaScript's <code>encodeURIComponent</code> function. Returns
     * <code>null</code> if the String is <code>null</code>.
     *
     * @param s The String to be encoded
     * @return the encoded String
     */
    public static String encodeURIComponent(String s) {
        String result = null;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("%21", "!")
                    .replaceAll("%27", "'")
                    .replaceAll("%28", "(")
                    .replaceAll("%29", ")")
                    .replaceAll("%7E", "~");
        }

        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    public static List<Object> toArrayList(String str) {
        TypeReference<ArrayList<Object>> typeRef = new TypeReference<ArrayList<Object>>() {
        };
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(str, typeRef);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static JsonNode toJsonNode(String str) {
        if (str == null) return null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            /*ObjectNode ret = new ObjectMapper().createObjectNode();
            String tmp;
            while(node.fieldNames().hasNext()) {
                tmp = node.fieldNames().next();
                ret.putPOJO(tmp.toLowerCase(),ret.get(tmp));
            }*/
            return mapper.readTree(str);
        } catch (IOException e) {
            return mapper.createObjectNode();
        }
    }

    public static List<Map<String, Object>> toMapList(String str) {
        TypeReference<List<Map<String, Object>>> typeRef = new TypeReference<List<Map<String, Object>>>() {
        };
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(str, typeRef);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void setBasicAuth(String token) {
        basicAuth = token;
    }


    public static String stringfy(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
