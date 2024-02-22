package cpm.pblgllgs.grpcflix.aggregator.controller;

import cpm.pblgllgs.grpcflix.aggregator.dto.RecommendedMovie;
import cpm.pblgllgs.grpcflix.aggregator.dto.UserGenre;
import cpm.pblgllgs.grpcflix.aggregator.service.UserMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *
 * @author pblgl
 * Created on 21-02-2024
 *
 */
@RestController
@RequiredArgsConstructor
public class AggregatorController {

    private final UserMovieService userMovieService;

    @GetMapping("/user/{loginId}")
    public List<RecommendedMovie> getMovies(@PathVariable("loginId") String loginId){
        return this.userMovieService.getUserMovieSuggestions(loginId);
    }

    @PutMapping("/user")
    public void setUserGenre(@RequestBody UserGenre userGenre){
        this.userMovieService.setUserGenre(userGenre);
    }
}
