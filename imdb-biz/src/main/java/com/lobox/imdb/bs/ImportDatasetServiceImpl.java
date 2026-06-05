package com.lobox.imdb.bs;

import com.lobox.imdb.bs.exception.DownloadException;
import com.lobox.imdb.bs.exception.ReadDatasetException;
import com.lobox.imdb.common.utils.FileUtility;
import com.lobox.imdb.si.ImportDatasetService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @author h.rostami
 * @since 02-Jun-2026
 */
@Service
public abstract class ImportDatasetServiceImpl implements ImportDatasetService {

    private static final int BATCH_SIZE = 5000;

    private static final String IMDB_URL = "https://datasets.imdbws.com/";


    public void importDataset() {

        if (!Files.exists(Path.of(getFileName()), LinkOption.NOFOLLOW_LINKS)) {
            try {
                FileUtility.downloadFile(IMDB_URL, getFileName(), getFileName());
            } catch (IOException | InterruptedException e) {
               throw new DownloadException();
            }
        }

        List<String> batch = new ArrayList<>(BATCH_SIZE);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(Files.newInputStream(Path.of(getFileName()))), StandardCharsets.UTF_8),
                1000000)) {
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                batch.add(line);
                if (batch.size() == BATCH_SIZE) {
                    persistBatch(batch);
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                persistBatch(batch);
            }
        } catch (IOException e) {
            throw new ReadDatasetException();
        }
    }

    public String[] parseLine(String line, int columnsCount) {

        String[] result = new String[columnsCount];

        int start = 0;
        int column = 0;

        for (int i = 0; i < line.length(); i++) {

            if (line.charAt(i) == '\t') {

                result[column++] = line.substring(start, i);

                start = i + 1;

                if (column == columnsCount - 1) {
                    break;
                }
            }
        }

        result[column] = line.substring(start);

        return result;
    }

    public abstract String getFileName();

    public abstract void persistBatch(List<String> dataList);

}
