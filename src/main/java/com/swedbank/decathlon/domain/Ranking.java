package com.swedbank.decathlon.domain;

public class Ranking {
    private int topPos;
    private int lastPos;
    private double score;

    public Ranking(double score) {
        this.score = score;
        this.topPos = Integer.MAX_VALUE;
        this.lastPos = Integer.MIN_VALUE;
    }

    public void addPos(int addPos) {
        topPos = topPos < addPos ? topPos : addPos;
        lastPos = lastPos > addPos ? lastPos : addPos;
    }

    public double getScore() {
        return score;
    }

    public String toString() {
        return topPos == lastPos ? String.valueOf(topPos) : String.format("%s-%s", topPos, lastPos);
    }
}
