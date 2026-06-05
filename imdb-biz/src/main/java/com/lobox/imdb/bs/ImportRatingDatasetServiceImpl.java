package com.lobox.imdb.bs;

import com.lobox.imdb.si.ImportRatingDatasetService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
@Service
public class ImportRatingDatasetServiceImpl extends ImportDatasetServiceImpl implements ImportRatingDatasetService {

    private final JdbcTemplate jdbcTemplate;

    public static final String FILE_NAME = "title.ratings.tsv.gz";

    public ImportRatingDatasetServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    @Override
    public void persistBatch(List<String> dataList) {
        jdbcTemplate.batchUpdate("INSERT INTO rating(title_id,average_rating,num_votes) values(?,?,?)", dataList, dataList.size(), (ps, line) -> {
            String[] data = parseLine(line, 9);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
        });
    }
}
