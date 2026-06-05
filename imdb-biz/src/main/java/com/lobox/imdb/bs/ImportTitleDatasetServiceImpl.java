package com.lobox.imdb.bs;

import com.lobox.imdb.common.dto.TitleGenreDto;
import com.lobox.imdb.si.ImportTitleDatasetService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
@Service
public class ImportTitleDatasetServiceImpl extends ImportDatasetServiceImpl implements ImportTitleDatasetService {

    private final JdbcTemplate jdbcTemplate;

    public static final String FILE_NAME = "title.basics.tsv.gz";

    public ImportTitleDatasetServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    @Override
    public void persistBatch(List<String> dataList) {
        jdbcTemplate.batchUpdate("INSERT INTO title(id,title_type,original_title,start_year) values(?,?,?,?)", dataList, dataList.size(), (ps, line) -> {
            String[] data = parseLine(line, 9);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[3]);
            if (data[5] == null || data[5].equals("\\N")) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, Integer.valueOf(data[5]));
            }
        });
        List<TitleGenreDto> titleGenreDtoList = new ArrayList<>();
        for(String line : dataList){
            String[] data = parseLine(line, 9);
            if(data[8] != null && !data[8].equals("\\N")){
                String[] genres = data[8].split(",");
                for(String genre : genres){
                    titleGenreDtoList.add(new TitleGenreDto(data[0], genre));
                }
            }
        }

        jdbcTemplate.batchUpdate("INSERT INTO title_genre(title_id,genre) values(?,?)", titleGenreDtoList, titleGenreDtoList.size(), (ps, line) -> {
            ps.setString(1, line.getTitleId());
            ps.setString(2, line.getGenre());
        });
    }
}
