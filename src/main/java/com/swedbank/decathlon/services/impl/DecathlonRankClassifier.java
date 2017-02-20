package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.Athlete;
import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.domain.Ranking;
import com.swedbank.decathlon.services.PointsCounter;
import com.swedbank.decathlon.services.RankClassifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecathlonRankClassifier implements RankClassifier<DecathlonAthlete> {

    private PointsCounter pointCounter;

    public DecathlonRankClassifier(PointsCounter pointCounter) {
        this.pointCounter = pointCounter;
    }

    public List<DecathlonAthlete> classifyRank(List<DecathlonAthlete> athletes) {
        pointCounter.countPoints(athletes);

        sortAthletesByTotalScore(athletes);

        rankSortedAthletes(athletes);

        return athletes;
    }

    private void sortAthletesByTotalScore(List<DecathlonAthlete> athletes) {
        athletes.sort((Athlete athl1, Athlete athl2) -> Integer.compare(athl2.getTotalScore(), athl1.getTotalScore()));
    }

    private void rankSortedAthletes(List<DecathlonAthlete> sortedAthletes) {
        Map<Double, Ranking> rankMap = new HashMap<>();
        for (int i = 0; i < sortedAthletes.size(); i++) {
            Athlete athlete = sortedAthletes.get(i);
            double score = athlete.getTotalScore();
            Ranking rank = rankMap.get(score);
            if (rank == null) {
                rank = new Ranking(score);
                rankMap.put(rank.getScore(), rank);
            }
            rank.addPos(i + 1);

            athlete.setRank(rank);
        }
    }
}
