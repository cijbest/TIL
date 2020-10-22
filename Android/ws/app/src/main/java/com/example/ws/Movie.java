package com.example.ws;

public class Movie {
    String movieCd;
    String rank;
    String movieNm;
    String img;
    String openDt;
    String salesAcc;
    String audiAcc;

    public Movie() {
    }

    public Movie(String movieCd, String rank, String movieNm, String img, String openDt, String salesAcc, String audiAcc) {
        this.movieCd = movieCd;
        this.rank = rank;
        this.movieNm = movieNm;
        this.img = img;
        this.openDt = openDt;
        this.salesAcc = salesAcc;
        this.audiAcc = audiAcc;
    }

    public Movie(String movieCd, String rank, String movieNm, String img) {
        this.movieCd = movieCd;
        this.rank = rank;
        this.movieNm = movieNm;
        this.img = img;
    }

    public String getMovieCd() {
        return movieCd;
    }

    public String getRank() {
        return rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public String getSalesAcc() {
        return salesAcc;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setMovieCd(String movieCd) {
        this.movieCd = movieCd;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public void setSalesAcc(String salesAcc) {
        this.salesAcc = salesAcc;
    }

    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }
}