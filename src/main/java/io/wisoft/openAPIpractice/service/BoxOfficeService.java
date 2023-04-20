package io.wisoft.openAPIpractice.service;

import io.wisoft.openAPIpractice.model.MovieListModel;
import io.wisoft.openAPIpractice.process.BoxOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoxOfficeService {

    @Autowired private BoxOffice boxOffice;

    public HashMap<String, String> runSearch(final String targetDt) {

        MovieListModel.MovieListRequest movieListRequest = new MovieListModel.MovieListRequest();
        MovieListModel.MovieListResponse movieListResponse = null;

        HashMap<String, String> result = new HashMap<>();

        try {

            movieListRequest.setRepNationCd("22041011"); //한국
            movieListRequest.setMovieTypeCd("220101"); //한국
            movieListResponse = boxOffice.searchMovieList(movieListRequest);

        } catch (Exception e) {
            //do nothing
        }

        return result;
    }

    public String movieListCard(final MovieListModel.MovieListResponse movieListResponse) {
        StringBuffer movieListCard = new StringBuffer();

        for (MovieListModel.Movie movie: movieListResponse.getMovieListResult().getMovieList()) {

            //대표 장르 | 영화명
            movieListCard.append(movie.getRepGenreNm() + " | " + movie.getMovieNm());
            movieListCard.append(System.lineSeparator());
        }

        return movieListCard.toString();
    }
}
