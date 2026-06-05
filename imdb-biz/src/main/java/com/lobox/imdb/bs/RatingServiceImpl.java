package com.lobox.imdb.bs;

import com.lobox.imdb.common.dto.HighRankedTitleDto;
import com.lobox.imdb.da.RatingDao;
import com.lobox.imdb.si.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
@Service
public class RatingServiceImpl implements RatingService {

    private final RatingDao ratingDao;

    public RatingServiceImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    public List<HighRankedTitleDto> getHighRatingTitlesByGenre(String genre) {
        List<Object[]> result = ratingDao.getHighRatingTitlesByGenre(genre);
        return result.stream()
                .map(row -> new HighRankedTitleDto(((Number) row[0]).intValue(), (String) row[1], ((Number) row[2]).floatValue(), ((Number) row[3]).intValue()))
                .collect(Collectors.toList());
    }
}
