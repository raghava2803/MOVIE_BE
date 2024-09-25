package dev.raghu.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "https://movieguide28.netlify.app") // Allow requests only from this frontend
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        Review createdReview = reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"));
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
