package com.irfan.stringalgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordFormatterTest {

    @Test
    void reverseCase_shouldReturnWordInReverseCase_whenGivenString() {
        String inputWords = "Saya SeDAng beLaJar BaHasa PemrOrgRaman JAVA";

        String expectedResult = "sAYA sEdaNG BElAjAR bAhASA pEMRoRGrAMAN java";
        String actualResult = WordFormatter.reverseCase(inputWords);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void reverseSequence_shouldReturnEachWordInReverse_whenGivenString() {
        String input = "saya sedang belajar berenang";

        String expectedResult = "ayas gnades rajaleb gnanereb";
        String actualResult = WordFormatter.reverseSequence(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPalindrom_shouldReturnTrue_whenGivenPalindromString() {
        String input1 = "KATAK";
        String input2 = "MALAM";

        Assertions.assertTrue(WordFormatter.isPalindrom(input1));
        Assertions.assertTrue(WordFormatter.isPalindrom(input2));
    }

    @Test
    void isPalindrom_shouldReturnFalse_whenGivenNonPalindromString() {
        String input = "MAKAN";

        Assertions.assertFalse(WordFormatter.isPalindrom(input));
    }
}
