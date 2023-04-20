package io.wisoft.openAPIpractice.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.DecimalFormat;

public class Utility {


    public static String getHttp(
            final String url,
            final String urlPath,
            final MultiValueMap<String, String> params) {

        WebClient client = WebClient.builder()
                .baseUrl(url)
//                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(urlPath)
                        .queryParams(params)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    static public Object getDecimalFormat(final String value, final String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(Integer.parseInt(value));
    }
}
