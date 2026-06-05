package com.lobox.imdb.bs;

import com.lobox.imdb.si.ImdbImportDatasetService;
import com.lobox.imdb.si.ImportRatingDatasetService;
import com.lobox.imdb.si.ImportTitleDatasetService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
@Service
public class ImdbImportDatasetServiceImpl implements ImdbImportDatasetService {

    private final ImportTitleDatasetService importTitleDatasetService;

    private final ImportRatingDatasetService importRatingDatasetService;

    private final JdbcTemplate jdbcTemplate;

    public ImdbImportDatasetServiceImpl(ImportTitleDatasetService importTitleDatasetService, ImportRatingDatasetService importRatingDatasetService,
                                        JdbcTemplate jdbcTemplate) {
        this.importTitleDatasetService = importTitleDatasetService;
        this.importRatingDatasetService = importRatingDatasetService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void importImdbDataset() {
        importTitleDatasetService.importDataset();
        importRatingDatasetService.importDataset();
        createIndexes();
    }

    private void createIndexes() {
        jdbcTemplate.batchUpdate("CREATE INDEX IF NOT EXISTS idx_title_id ON TITLE(ID);");
        jdbcTemplate.batchUpdate("CREATE INDEX IF NOT EXISTS idx_rating_title_id ON RATING(TITLE_ID);");
    }

}
