package io.wisoft.openAPIpractice.process;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.wisoft.openAPIpractice.common.util.Utility;
import io.wisoft.openAPIpractice.model.MovieListModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class BoxOffice {
    private static String url = "http://kobis.os.kr";

    @Value("spring.open-api.secret-key")
    private static String secretKey;

    public MovieListModel.MovieListResponse searchMovieList(final MovieListModel.MovieListRequest movieListRequest) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        String urlPath = "/kobisopenapi/webservice/rest/movie/searchMovieList.json";
        String result = "";

        params.add("key", secretKey);
        params.add("repNationCd", movieListRequest.getRepNationCd());
        params.add("movieTypeCd", movieListRequest.getMovieTypeCd());

        result = Utility.getHttp(url, urlPath, params);

        return objectMapper.readValue(result, MovieListModel.MovieListResponse.class);
    }
}
