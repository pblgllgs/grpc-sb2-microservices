package cpm.pblgllgs.grpcflix.aggregator.service;
/*
 *
 * @author pblgl
 * Created on 21-02-2024
 *
 */

import com.pblgllgs.common.Genre;
import com.pblgllgs.movie.MovieSearchRequest;
import com.pblgllgs.movie.MovieSearchResponse;
import com.pblgllgs.movie.MovieServiceGrpc;
import com.pblgllgs.user.UserGenreUpdateRequest;
import com.pblgllgs.user.UserResponse;
import com.pblgllgs.user.UserSearchRequest;
import com.pblgllgs.user.UserServiceGrpc;
import cpm.pblgllgs.grpcflix.aggregator.dto.RecommendedMovie;
import cpm.pblgllgs.grpcflix.aggregator.dto.UserGenre;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMovieService {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userStub;

    @GrpcClient("movie-service")
    private MovieServiceGrpc.MovieServiceBlockingStub movieStub;

    public List<RecommendedMovie> getUserMovieSuggestions(String loginId) {
        UserSearchRequest userSearchRequest = UserSearchRequest.newBuilder().setLoginId(loginId).build();
        UserResponse userResponse = this.userStub.getUserGenre(userSearchRequest);
        MovieSearchRequest movieSearchRequest = MovieSearchRequest.newBuilder().setGenre(userResponse.getGenre()).build();
        MovieSearchResponse movieSearchResponse = this.movieStub.getMovies(movieSearchRequest);
        return movieSearchResponse.getMovieList()
                .stream()
                .map(movie ->
                        new RecommendedMovie(
                                movie.getTitle(),
                                movie.getYear(),
                                movie.getRating())
                ).collect(Collectors.toList());

    }
    public void setUserGenre(UserGenre userGenre){
        UserGenreUpdateRequest userGenreUpdateRequest = UserGenreUpdateRequest.newBuilder()
                .setLoginId(userGenre.getLoginId())
                .setGenre(Genre.valueOf(userGenre.getGenre().toUpperCase()))
                .build();
        this.userStub.updateUserGenre(userGenreUpdateRequest);
    }
}
