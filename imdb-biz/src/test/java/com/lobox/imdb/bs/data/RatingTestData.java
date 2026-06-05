package com.lobox.imdb.bs.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
public class RatingTestData {

    public List<Object[]> getRatingList() {
        List<Object[]> result = new ArrayList();
        Object[] firstRecord = {1993, "Schindler's List", 9.9f, 56000};
        Object[] secondRecord = {1994, "he Shawshank Redemption", 10f, 100000};
        result.add(firstRecord);
        result.add(secondRecord);
        return result;
    }

}
