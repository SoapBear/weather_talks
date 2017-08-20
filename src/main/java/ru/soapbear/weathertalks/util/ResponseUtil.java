package ru.soapbear.weathertalks.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private static final HttpHeaders headers = new HttpHeaders();
    static {
        headers.add("h1", "v1");
    }

    public static <T> ResponseEntity<T> createResponse(T entity) {
        return new ResponseEntity<T>(entity, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> createResponseWithDefaultHeaders(T entity) {

        return new ResponseEntity<>(entity, headers, HttpStatus.OK);
    }

}
