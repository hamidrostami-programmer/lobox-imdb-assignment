package com.lobox.imdb.bs.exception;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
public class DownloadException extends RuntimeException {
    public DownloadException() {
        super("Download failed");
    }
}
