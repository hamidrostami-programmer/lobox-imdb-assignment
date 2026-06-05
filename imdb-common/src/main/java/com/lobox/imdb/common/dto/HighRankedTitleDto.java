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
public class HighRankedTitleDto {

    private Integer year;
    private String title;
    private Float averageRating;
    private Integer numberOfVotes;

    public HighRankedTitleDto(Integer year, String title, Float averageRating, Integer numberOfVotes) {
        this.year = year;
        this.title = title;
        this.averageRating = averageRating;
        this.numberOfVotes = numberOfVotes;
    }

    public Integer getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Integer numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
