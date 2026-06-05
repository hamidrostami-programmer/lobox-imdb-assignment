package com.lobox.imdb.web.controller;

import com.lobox.imdb.common.dto.HighRankedTitleDto;
import com.lobox.imdb.si.ImdbImportDatasetService;
import com.lobox.imdb.si.RatingService;
import com.lobox.imdb.web.config.RequestCounter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author h.rostami
 * @since 02-Jun-2026
 */
@RestController
@RequestMapping("/api/imdb")
public class ImdbController {

    private final ImdbImportDatasetService imdbImportDatasetService;

    private final RatingService ratingService;

    private final RequestCounter requestCounter;

    public ImdbController(ImdbImportDatasetService imdbImportDatasetService, RatingService ratingService, RequestCounter requestCounter) {
        this.imdbImportDatasetService = imdbImportDatasetService;
        this.ratingService = ratingService;
        this.requestCounter = requestCounter;
    }

    @GetMapping("/importDataset")
    public ResponseEntity<Map<String, Object>> importDataset() {
        imdbImportDatasetService.importImdbDataset();
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "import completed successfully");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/highRatedTitlesByGenre")
    public ResponseEntity<List<HighRankedTitleDto>> getHighRatingTitlesByGenre(@RequestParam(name = "genre") String genre) {
        List<HighRankedTitleDto> result = ratingService.getHighRatingTitlesByGenre(genre);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/requestCount")
    public ResponseEntity<Long> getRequestCount() {
        return ResponseEntity.ok(requestCounter.getCount());
    }
}
