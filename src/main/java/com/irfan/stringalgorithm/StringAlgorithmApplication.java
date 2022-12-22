package com.irfan.stringalgorithm;

import java.util.List;
import java.util.Map;

public class StringAlgorithmApplication {

	public static void main(String[] args) {
		/**
		 * Soal 2.1
		 * Input data : Saya SeDAng beLaJar BaHasa PemrOrgRaman JAVA
		 * Output data : sAYA sEdaNG BElAjAR bAhASA pEMRoRGrAMAN java
		 */
		System.out.println("======= Soal 2.1 =======");
		String input1 = "Saya SeDAng beLaJar BaHasa PemrOrgRaman JAVA";
		String output1 = WordFormatter.reverseCase(input1);

		System.out.println("Input data : " + input1);
		System.out.println("Output data : " + output1);

		/**
		 * Soal 2.2
		 * Input data : saya sedang belajar berenang
		 * Output data : ayas gnades rajaleb gnanereb
		 */
		System.out.println("\n======= Soal 2.2 =======");
		String input2 = "saya sedang belajar berenang";
		String output2 = WordFormatter.reverseSequence(input2);

		System.out.println("Input data : " + input2);
		System.out.println("Output data : " + output2);

		/**
		 * Soal 2.3
		 * Input data : KATAK, MAKAN, MALAM
		 * Output data :
		 * KATAK merupakan palindrom
		 * MAKAN bukan palindrom
		 * MALAM merupakan palindrom
		 */
		System.out.println("\n======= Soal 2.3 =======");
		String[] input3 = {"KATAK", "MAKAN", "MALAM"};
		for (String w : input3) {
			boolean isPalindrom = WordFormatter.isPalindrom(w);
			System.out.println(w + (isPalindrom?" ":" bukan ") + "merupakan palindrom");
		}

		/**
		 *  Soal 2.4
		 * jumlah kata
		 * jumlah kemunculan tiap kata
		 * jumlah kata yang muncul satu kali
		 * jumlah kata yang paling banyak muncul dan katanya
		 * jumlah kata yang paling sedikit muncul dan katanya
		 */
		System.out.println("\n======= Soal 2.4 =======");

		String data =  "Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995. Bahasa ini banyak mengadopsi sintaksis yang terdapat pada C dan C++ namun dengan sintaksis model objek yang lebih sederhana serta dukungan rutin-rutin aras bawah yang minimal. Aplikasi-aplikasi berbasis java umumnya dikompilasi ke dalam bytecode dan dapat dijalankan pada berbagai Mesin Virtual Java.\n" +
				"\n" +
				"Java merupakan bahasa pemrograman yang bersifat umum dan secara khusus didesain untuk memanfaatkan dependensi implementasi seminimal mungkin. Karena fungsionalitasnya yang memungkinkan aplikasi java mampu berjalan di beberapa platform sistem operasi yang berbeda, java dikenal pula dengan slogannya, Tulis sekali, jalankan di mana pun. Saat ini java merupakan bahasa pemrograman yang paling populer digunakan, dan secara luas dimanfaatkan dalam pengembangan berbagai jenis perangkat lunak";
		SentenceStatistics sentenceStatistics = new SentenceStatistics(data);

		System.out.println("Jumlah kata : " + sentenceStatistics.getTotalCount());
		System.out.println("Jumlah kemunculan tiap kata : " + sentenceStatistics.getSentencesMap());
		System.out.println("Jumlah kata yang muncul satu kali : " + sentenceStatistics.getNumberOfWordByAppearance(1));

		Integer maximumWordAppeared = sentenceStatistics.getMaximumWordAppeared();
		List<String> mostAppearedWord = sentenceStatistics.getMostAppearedWords();
		System.out.println("Jumlah kata yang paling banyak muncul dan katanya : " + maximumWordAppeared + " kali = " + mostAppearedWord);

		Integer minimumWordAppeared = sentenceStatistics.getMinimumWordAppeared();
		List<String> leastAppearedWord = sentenceStatistics.getLeastAppearedWords();
		System.out.println("Jumlah kata yang paling sedikit muncul dan katanya : " + minimumWordAppeared + " kali = " + leastAppearedWord);
	}

}
