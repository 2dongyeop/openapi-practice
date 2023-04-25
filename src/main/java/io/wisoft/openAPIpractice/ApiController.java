package io.wisoft.openAPIpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Open API를 이용해 공공 데이터를 가져오기
 */

@RestController
public class ApiController {

    @GetMapping("/api/hospinfo")
    public String getHospitalInfo() throws IOException {

        /**
         * 이 포스팅은 "건강보험심사평가원_병원정보서비스" 를 이용하였습니다.
         * 아래 링크 참고
         * https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15001698
         */
        String apiURL = "https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?ServiceKey={인코딩 인증키}&pageNo=1";

        /**
         * GET방식으로 전송해서 파라미터 받아오기
         */
        URL url = new URL(apiURL);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");


        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();

        return sb.toString();
    }

}
