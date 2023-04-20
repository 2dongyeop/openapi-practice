package io.wisoft.openAPIpractice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class MovieListModel {

    /**
     * 요청 구조 및 응답 구조는 아래 링크에서 변수 값 및 설명 확인
     * https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do
     */

    @Getter @Setter
    static public class MovieListRequest {
        private String curPage;        //현재 페이지를 지정
        private String iterPerPage;    //결과 ROW의 개수를 지정
        private String movieNm;        //영화명
        private String directorNm;     //감독명
        private String openStartDt;   //조회시작 개봉연도
        private String openEndDt;     //조회종료 개봉연도
        private String prdtStartYear; //제작 상태
        private String repNationCd;   //N개의 국적 코드
        private String movieTypeCd;   //영화 유형 코드
    }

    @Getter @Setter
    static public class MovieListResponse {
        private MovieListResult movieListResult;
    }

    @Getter @Setter
    static public class MovieListResult {
        private int totCont;
        private String source;
        private ArrayList<Movie> movieList;
    }

    @Getter @Setter
    static public class Movie {
        private String movieCd;
        private String movieNm;
        private String movieNmEn;
        private String prdtYear;
        private String openDt;
        private String typeNm;
        private String prdtStatNm;
        private String nationAlt;
        private String genreAlt;
        private String repNationNm;
        private String repGenreNm;
        private ArrayList<Director> directors;
        private ArrayList<Company> companies;
    }

    @Getter @Setter
    static public class Director {
        private String peopleNm;
    }

    @Getter @Setter
    static public class Company {
        private String companyCd;
        private String companyNm;
    }
}
