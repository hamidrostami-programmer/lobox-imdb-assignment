package com.lobox.imdb.bs;

import com.lobox.imdb.bs.data.RatingTestData;
import com.lobox.imdb.common.dto.HighRankedTitleDto;
import com.lobox.imdb.da.RatingDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
@ExtendWith(MockitoExtension.class)
public class RatingServiceImplTest {

    @Mock
    private RatingDao ratingDao;

    @InjectMocks
    private RatingServiceImpl ratingService;

    private RatingTestData ratingTestData;

    @BeforeEach
    void setUp() {
        ratingTestData = new RatingTestData();
    }

    @Test
    void getHighRatingTitlesByGenre() {

        String genre = "Drama";

        List<Object[]> daoResult = ratingTestData.getRatingList();

        when(ratingDao.getHighRatingTitlesByGenre(genre))
                .thenReturn(daoResult);

        List<HighRankedTitleDto> result =
                ratingService.getHighRatingTitlesByGenre(genre);

        assertEquals(2, result.size());
    }

}
