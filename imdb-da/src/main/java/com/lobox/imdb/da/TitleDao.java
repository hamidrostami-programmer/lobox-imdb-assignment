package com.lobox.imdb.da;

import com.lobox.imdb.da.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author h.rostami
 * @since 02-Jun-2026
 */
@Repository
public interface TitleDao extends JpaRepository<TitleEntity, Long> {

}
