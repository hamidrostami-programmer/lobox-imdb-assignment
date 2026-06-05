package com.lobox.imdb.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author h.rostami
 * @since 03-Jun-2026
 */
@Data
@NoArgsConstructor
public class TitleGenreDto {

    private String titleId;
    private String genre;

    public TitleGenreDto(String titleId, String genre) {
        this.titleId = titleId;
        this.genre = genre;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
