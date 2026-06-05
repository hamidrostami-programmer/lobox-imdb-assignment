package com.lobox.imdb.web.controller;

import com.lobox.imdb.bs.exception.DownloadException;
import com.lobox.imdb.bs.exception.ReadDatasetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
@ControllerAdvice
public class ImdbControllerExceptionHandler {

    @ExceptionHandler({DownloadException.class})
    public ResponseEntity<Object> handleDownloadException(DownloadException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ReadDatasetException.class})
    public ResponseEntity<Object> handleReadDatasetException(ReadDatasetException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
