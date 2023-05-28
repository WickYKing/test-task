package com.testtask.backendCodingTask.Service;

import com.testtask.backendCodingTask.Entity.Movies;
import com.testtask.backendCodingTask.Entity.Ratings;
import com.testtask.backendCodingTask.PayLoads.MoviesDto;

import java.util.List;

public interface MovieService {
    List<MoviesDto> getTopTenLongestDurationMovies();

     List<MoviesDto> getTopRatedMovies();
  //  List<MoviesDto> convertToMovieDtoList(List<Movies> movies);


    //    public List<MoviesDto> convertToMovieDtoList(List<Movies> movies) {
//        return null;
//    }
    // List<MoviesDto> convertToMovieDtoList(List<Movies> movies, List<Ratings> ratings);
}
