package com.lobox.imdb.da.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author h.rostami
 * @since 02-Jun-2026
 */
@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingEntity implements Serializable {

    @Id
    @Column(name = "title_id", nullable = false)
    private String titleId;

    @Column(name = "average_rating", nullable = false)
    private Float averageRating;

    @Column(name = "num_votes", nullable = false)
    private Integer numberOfVotes;

}
