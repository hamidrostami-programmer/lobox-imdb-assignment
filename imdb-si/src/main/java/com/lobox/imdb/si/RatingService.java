package com.lobox.imdb.si;

import com.lobox.imdb.common.dto.HighRankedTitleDto;

import java.util.List;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
public interface RatingService {

    List<HighRankedTitleDto> getHighRatingTitlesByGenre(String genre);
}
