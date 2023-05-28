package com.testtask.backendCodingTask.Controller;

import com.testtask.backendCodingTask.PayLoads.MoviesDto;
import com.testtask.backendCodingTask.PayLoads.NewMovieDto;
import com.testtask.backendCodingTask.Service.MovieService;
import com.testtask.backendCodingTask.Service.NewMoviesServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class MoviesController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private NewMoviesServies newMoviesServies;

    @GetMapping("/v1/longest-duration-movies")
    public ResponseEntity<List<MoviesDto>> getTopTenLongestDurationMovies() {
        List<MoviesDto> getTopTenLongestDurationMovies = this.movieService.getTopTenLongestDurationMovies();
        return ResponseEntity.ok(getTopTenLongestDurationMovies);
    }
        @PostMapping("/v1/new-movie")
        public ResponseEntity<?> createNewMovies(@RequestBody NewMovieDto newMovieDto) {
        NewMovieDto AddNewEntry = this.newMoviesServies.createNewMovies(newMovieDto);
        return new ResponseEntity<>("Success" + AddNewEntry,HttpStatus.OK);
//            return ResponseEntity.ok(AddNewEntry);
        }

    @GetMapping("/v1/top-rated-movies")
    public ResponseEntity<List<MoviesDto>> topratedmovies(@RequestBody MoviesDto moviesDto) {
         List<MoviesDto> topratedmovies=this.movieService.getTopRatedMovies();
        return ResponseEntity.ok((List<MoviesDto>) topratedmovies);
    }

}