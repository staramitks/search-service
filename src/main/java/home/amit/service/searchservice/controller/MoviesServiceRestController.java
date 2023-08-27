package home.amit.service.searchservice.controller;
/*
User :- AmitSingh
Date :- 8/27/2023
Time :- 9:40 PM
Year :- 2023
*/

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class MoviesServiceRestController {

    @GetMapping("/movies")
    public ResponseEntity<String> getMoviesMessage()
    {
        return ResponseEntity.ok("This is coming from search-service with /api/v1/movies service ");
    }
}
