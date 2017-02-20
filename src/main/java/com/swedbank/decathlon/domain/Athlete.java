package com.swedbank.decathlon.domain;

public abstract class Athlete {

    private String name;
    private Integer totalScore;
    private Ranking rank;

    public Athlete(String name, Integer totalScore) {
        this.name = name;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Ranking getRank() {
        return rank;
    }

    public void setRank(Ranking rank) {
        this.rank = rank;
    }
}
