package com.lobox.imdb.common.utils;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPInputStream;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
public class FileUtility {

    public static void downloadFile(String url, String sourceFileName, String destinationFileName) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + sourceFileName)).GET().build();

        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        try (InputStream in = response.body(); OutputStream out = Files.newOutputStream(Path.of(destinationFileName))) {

            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }
    }

    public static void unzip(String zipFile, String destFile) throws IOException {

        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(zipFile)); FileOutputStream fos = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[8192];
            int len;

            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
    }
}
