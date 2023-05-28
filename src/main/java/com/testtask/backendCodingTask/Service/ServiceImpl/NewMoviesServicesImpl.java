package com.testtask.backendCodingTask.Service.ServiceImpl;

import com.testtask.backendCodingTask.Entity.Movies;
import com.testtask.backendCodingTask.Entity.Ratings;
import com.testtask.backendCodingTask.PayLoads.MoviesDto;
import com.testtask.backendCodingTask.PayLoads.NewMovieDto;
import com.testtask.backendCodingTask.PayLoads.RatingDto;
import com.testtask.backendCodingTask.Repository.MoviesRepo;
import com.testtask.backendCodingTask.Repository.RatingRepo;
import com.testtask.backendCodingTask.Service.NewMoviesServies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewMoviesServicesImpl implements NewMoviesServies {
    @Autowired
    private MoviesRepo moviesRepo;
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private ModelMapper modelMapper;

    public NewMovieDto createNewMovies(NewMovieDto newMovieDto) {
        System.out.println("DTO: " + newMovieDto);

        Movies movies = new Movies();
        movies.setId(newMovieDto.getId());
        movies.setTitleType(newMovieDto.getTitleType());
        movies.setPrimaryTitle(newMovieDto.getPrimaryTitle());
        movies.setRuntimeMinutes(newMovieDto.getRuntimeMinutes());
        movies.setGenres(newMovieDto.getGenres());
        System.out.println("Movies" + movies);
        moviesRepo.save(movies);
        Ratings ratings = new Ratings();
        ratings.setId(newMovieDto.getId());
        ratings.setAverageRating(newMovieDto.getAverageRating());
        ratings.setNumVotes(newMovieDto.getNumVotes());
        System.out.println("Rating" + ratings);
        ratingRepo.save(ratings);
        return newMovieDto;

    }
}
