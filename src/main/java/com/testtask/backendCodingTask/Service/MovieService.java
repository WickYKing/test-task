package com.testtask.backendCodingTask.Service;

import com.testtask.backendCodingTask.PayLoads.GenreMoviesSubtotalsDto;
import com.testtask.backendCodingTask.PayLoads.MoviesDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieService {
    List<MoviesDto> getTopTenLongestDurationMovies();

    public List<MoviesDto> getTopRatedMovies();
    // List<MoviesDto> convertToMovieDtoList(List<Movies> movies, List<Ratings> ratings);


    List<GenreMoviesSubtotalsDto> getGenreMoviesWithSubtotals();

    void updateRuntimeMinutes();

}
