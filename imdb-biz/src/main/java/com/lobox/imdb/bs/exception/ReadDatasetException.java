package com.lobox.imdb.bs.exception;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
public class ReadDatasetException extends RuntimeException {
    public ReadDatasetException() {
        super("Dataset is not valid");
    }
}
