package com.irfan.stringalgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class SentenceStatisticsTest {

    private static SentenceStatistics sentenceStatistics;

    @BeforeAll
    static void setUp() {
        String data =  "Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995. Bahasa ini banyak mengadopsi sintaksis yang terdapat pada C dan C++ namun dengan sintaksis model objek yang lebih sederhana serta dukungan rutin-rutin aras bawah yang minimal. Aplikasi-aplikasi berbasis java umumnya dikompilasi ke dalam bytecode dan dapat dijalankan pada berbagai Mesin Virtual Java.\n" +
                "\n" +
                "Java merupakan bahasa pemrograman yang bersifat umum dan secara khusus didesain untuk memanfaatkan dependensi implementasi seminimal mungkin. Karena fungsionalitasnya yang memungkinkan aplikasi java mampu berjalan di beberapa platform sistem operasi yang berbeda, java dikenal pula dengan slogannya, Tulis sekali, jalankan di mana pun. Saat ini java merupakan bahasa pemrograman yang paling populer digunakan, dan secara luas dimanfaatkan dalam pengembangan berbagai jenis perangkat lunak";
        sentenceStatistics = new SentenceStatistics(data);
    }

    @Test
    void wordCount_sholdReturnTotalWord_whenInvoked() {
        Integer expectedResult = 142;
        Integer actualResult = sentenceStatistics.getTotalCount();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void sentencesMap() {
        Map<String, Integer> map = sentenceStatistics.getSentencesMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Test
    void getAppearanceOf_shouldReturnNumberOfWordThatAppeared_whenGivenWord() {
        Integer expectedResult = 9;

        String word = "yang";
        Integer actualResult = sentenceStatistics.getAppearanceOf(word);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMinimumWordAppeared_shouldReturnMinimumWordAppeared_whenInvoked() {
        Integer expectedResult = 1;
        Integer actualResult = sentenceStatistics.getMinimumWordAppeared();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMaximumWordAppeared_shouldReturnMaximumWordAppeared_whenInvoked() {
        Integer expectedResult = 9;
        Integer actualResult = sentenceStatistics.getMaximumWordAppeared();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getNumberOfWordByAppearance_shouldReturnNumberOfWordThatAppeared_whenGivenTotalAppearance() {
        Integer expectedResult = 1;

        Integer appearance = 9;
        Integer actualResult = sentenceStatistics.getNumberOfWordByAppearance(appearance);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMostAppearedWords_shouldReturnListOfMostAppearedWord_whenInvoked() {
        Integer expectedResult = 1; // 1 word that appeared 9 time

        List<String> mostAppearedWords = sentenceStatistics.getMostAppearedWords();
        Integer actualResult = mostAppearedWords.size();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getLeastAppearedWords_shouldReturnListOfLeastAppearedWord_whenInvoked() {
        Integer expectedResult = 82; // 82 words that appeared 1 time

        List<String> leastAppearedWords = sentenceStatistics.getLeastAppearedWords();
        Integer actualResult = leastAppearedWords.size();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
