package com.pblgllgs.grpcflix.movie.service;
/*
 *
 * @author pblgl
 * Created on 21-02-2024
 *
 */

import com.pblgllgs.grpcflix.movie.repository.MovieRepository;
import com.pblgllgs.movie.MovieDto;
import com.pblgllgs.movie.MovieSearchRequest;
import com.pblgllgs.movie.MovieSearchResponse;
import com.pblgllgs.movie.MovieServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.stream.Collectors;


@GrpcService
@RequiredArgsConstructor
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {

    private final MovieRepository movieRepository;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getMovies(MovieSearchRequest request, StreamObserver<MovieSearchResponse> responseObserver) {
        List<MovieDto> movieDtoList = this.movieRepository.getMovieByGenreOrderByYearDesc(request.getGenre().toString())
                .stream()
                .map(movie -> MovieDto.newBuilder()
                        .setTitle(movie.getTitle())
                        .setYear(movie.getYear())
                        .setRating(movie.getRating())
                        .build()).collect(Collectors.toList());
        responseObserver.onNext(MovieSearchResponse.newBuilder().addAllMovie(movieDtoList).build());
        responseObserver.onCompleted();
    }
}
