package com.testtask.backendCodingTask.Service.ServiceImpl;

import com.testtask.backendCodingTask.Entity.Movies;
import com.testtask.backendCodingTask.Entity.Ratings;
import com.testtask.backendCodingTask.PayLoads.MoviesDto;
import com.testtask.backendCodingTask.Repository.MoviesRepo;
import com.testtask.backendCodingTask.Repository.RatingRepo;
import com.testtask.backendCodingTask.Service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MoviesRepo moviesRepo;
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MoviesDto> getTopTenLongestDurationMovies() {
        List<Movies> movie =this.moviesRepo.findTop10ByOrderByRuntimeMinutesDesc();
        List<MoviesDto> movieDtos = new ArrayList<>();
        for (MoviesDto movies : movieDtos) {
            Object averageRating = null;
            MoviesDto movieDto = new MoviesDto(movies.getId(), movies.getPrimaryTitle(), movies.getGenres(), averageRating);
            movieDto.setId(movies.getId());
            movieDto.setTitleType(movies.getTitleType());
            movieDto.setPrimaryTitle(movies.getPrimaryTitle());
            movieDto.setRuntimeMinutes(movies.getRuntimeMinutes());
            movieDto.setGenres(movies.getGenres());
            movieDtos.add(movieDto);
        }

      List<MoviesDto> MoviesDtoList = movieDtos.stream().map(moviesDto -> this.modelMapper.map(moviesDto, MoviesDto.class)).collect(Collectors.toList());
        return movieDtos;
    }

    @Override
    public List<MoviesDto> getTopRatedMovies() {
        List<Ratings> topRatedRatings = ratingRepo.findByAverageRatingGreaterThanOrderByAverageRatingDesc(6.0F);
        List<String> IdList = topRatedRatings.stream().map(Ratings::getId).collect(Collectors.toList());
        List<Movies> topRatedMovies = moviesRepo.findAllById(IdList);
        return convertToMovieDtoList(topRatedMovies, topRatedRatings);
    }
    public List<MoviesDto> convertToMovieDtoList(List<Movies> movies, List<Ratings> ratings) {
        List<MoviesDto> movieDtoList = new ArrayList<>();
        Map<String, Float> ratingMap = ratings.stream().collect(Collectors.toMap(Ratings::getId, Ratings::getAverageRating));
        for (Movies movie : movies) {
            Float averageRating = ratingMap.get(movie.getId());
            MoviesDto movieDto = new MoviesDto(movie.getId(), movie.getPrimaryTitle(), movie.getGenres(), averageRating);
            movieDtoList.add(movieDto);
        }
        return movieDtoList;
    }
}
