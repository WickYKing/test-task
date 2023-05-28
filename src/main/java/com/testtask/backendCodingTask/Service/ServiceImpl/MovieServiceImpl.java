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
        List<Movies> movies = moviesRepo.findTop10ByOrderByRuntimeMinutesDesc();
        List<MoviesDto> movieDtos = new ArrayList<>();

        for (Movies movie : movies) {
            MoviesDto movieDto = new MoviesDto();
            movieDto.setId(movie.getId());
            movieDto.setTitleType(movie.getTitleType());
            movieDto.setPrimaryTitle(movie.getPrimaryTitle());
            movieDto.setRuntimeMinutes(movie.getRuntimeMinutes());
            movieDto.setGenres(movie.getGenres());
            movieDtos.add(movieDto);
        }

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
