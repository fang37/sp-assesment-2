package com.irfan.stringalgorithm;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
public class SentenceStatistics {
    private final String[] sentences;
    private Map<String, Integer> sentencesMap = new HashMap<>();


    public SentenceStatistics(String sentences) {
        this.sentences = sentences.replace("," , "").replace(".", "").split("\\s+");

        Arrays.stream(this.sentences)
                .map(String::toLowerCase)
                .forEach(e -> {
                    if (sentencesMap.containsKey(e)) {
                        sentencesMap.put(e, sentencesMap.get(e) + 1);
                    } else sentencesMap.put(e, 1);
                });
    }

    public Integer getTotalCount() {
        return sentences.length;
    }

    public Integer getAppearanceOf(String word) {
        if (sentencesMap.containsKey(word)) {
            return sentencesMap.get(word);
        }
        return 0;
    }

    public Integer getNumberOfWordByAppearance(Integer appear) {
        Integer total = 0;

        for (Map.Entry<String, Integer> entry : sentencesMap.entrySet()) {
            if (entry.getValue() == appear) total ++;

        }
        return total;
    }

    public Integer getMaximumWordAppeared() {
        Optional<Integer> max = sentencesMap.values().stream().max((Integer a, Integer b) -> a.compareTo(b));
        if (max.isPresent()) {
            return max.get();
        }
        return 0;
    }

    public List<String> getMostAppearedWords() {
        Integer max = getMaximumWordAppeared();

        if (max > 0) {
            List<String> maxList = sentencesMap.entrySet().stream().filter(entry -> entry.getValue() == max).map(entry -> entry.getKey()).collect(Collectors.toList());
            return maxList;
        }
        return List.of();
    }


    public Integer getMinimumWordAppeared() {
        Optional<Integer> min = sentencesMap.values().stream().min((Integer a, Integer b) -> a.compareTo(b));
        if (min.isPresent()) {
            return min.get();
        }
        return 0;
    }
    public List<String> getLeastAppearedWords() {
        Integer min = getMinimumWordAppeared();

        if (min > 0) {
            List<String> minList = sentencesMap.entrySet().stream().filter(entry -> entry.getValue() == min).map(entry -> entry.getKey()).collect(Collectors.toList());
            return minList;
        }
        return List.of();
    }




}
