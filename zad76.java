package zad76;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class zad76 {

	public static String szyfrowanie(String A, int[] P) {
		// TODO Auto-generated method stub
		int dl = A.length();
		int n = P.length;
		ArrayList<String> wynik = new ArrayList<>();
		String[] split = A.split("");
		for (String a : split) {
			wynik.add(a);
		}
		for (int i = 1; i <= dl; i++) {

			Collections.swap(wynik, i - 1, P[(i - 1) % n] - 1);
		}
		String wynik_str = String.join("", wynik);

		return wynik_str;
	}

	public static String deszyfrowanie(String A, int[] P) {
		// TODO Auto-generated method stub
		int dl = A.length();
		int n = P.length;
		ArrayList<String> wynik = new ArrayList<>();
		String[] split = A.split("");
		for (String a : split) {
			wynik.add(a);
		}
		for (int i = dl; i >= 1; i--) {

			Collections.swap(wynik, i - 1, P[(i - 1) % n] - 1);
		}
		String wynik_str = String.join("", wynik);

		return wynik_str;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(new File("szyfr1.txt"));
		Scanner s2 = new Scanner(new File("szyfr2.txt"));
		Scanner s3 = new Scanner(new File("szyfr3.txt"));
		FileWriter z1=new FileWriter("test.txt");
		System.out.println("Zad1. ");
		ArrayList<String> lista = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			lista.add(s1.nextLine());//
		}
		String klucz_ln = lista.get(6);
		String napis2 = s2.nextLine();
		String temp = s2.nextLine();
		String[] klucz_tab = klucz_ln.split(" ");
		String[] klucz_tab2 = temp.split(" ");
		int[] klucz2 = new int[klucz_tab2.length];
		int[] klucz = new int[klucz_tab.length];

		for (int j = 0; j < klucz_tab.length; j++) {
			klucz[j] = Integer.parseInt(klucz_tab[j]);
		}
		for (int j = 0; j < klucz_tab2.length; j++) {
			klucz2[j] = Integer.parseInt(klucz_tab2[j]);
		}
		for (int i = 0; i < 6; i++) {
			System.out.println(szyfrowanie(lista.get(i), klucz));
		}
		////////////////////////////
		System.out.println("Zad2. ");
		System.out.println(szyfrowanie(napis2, klucz2));
		/////////////////////////
		System.out.println("Zad3. ");
		String napis3 = s3.nextLine();
		int[] klucz3 = { 6, 2, 4, 1, 5, 3 };
		System.out.println(deszyfrowanie(napis3, klucz3));

	}

}
