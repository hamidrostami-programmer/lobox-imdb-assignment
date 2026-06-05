package com.lobox.imdb.da;

import com.lobox.imdb.da.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author h.rostami
 * @since 02-Jun-2026
 */
@Repository
public interface RatingDao extends JpaRepository<RatingEntity, Long> {

    @Query(value = "WITH high_ranked_titles AS (SELECT  title.start_year,title.id,title.original_Title," +
            "            rating.average_rating,rating.num_votes, ROW_NUMBER() OVER (PARTITION BY title.start_Year" +
            "                        ORDER BY rating.average_rating DESC,rating.num_votes DESC) AS rank_number FROM Rating rating" +
            "                         INNER JOIN  Title title ON title.id = rating.title_id" +
            "                         inner join title_genre genre on genre.TITLE_ID = rating.TITLE_ID" + "                         WHERE genre.GENRE = :genre)" +
            "             SELECT start_Year,original_title,average_rating, num_votes FROM high_ranked_titles" +
            "             WHERE rank_number = 1 AND start_Year IS NOT NULL ORDER BY start_year;", nativeQuery = true)
    List<Object[]> getHighRatingTitlesByGenre(@Param("genre") String genre);

}
