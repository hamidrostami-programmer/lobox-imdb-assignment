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
@Table(name = "title")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleEntity implements Serializable {

    @Id
    @Column(name = "unique_identifier", nullable = false)
    private String uniqueIdentifier;

    @Column(name = "title_type", nullable = false)
    private String titleType;

    @Column(name = "original_title", nullable = false)
    private String originalTitle;

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

}
