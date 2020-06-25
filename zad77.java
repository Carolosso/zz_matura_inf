package zad77;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class zad77 {

	static int i_kl = 0;
	static int i_kl2 = 0;
	static int pow = 1;
	static final String[] alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

	public static String szyfrowanie(String wyraz, String klucz) {
		String[] znaki = wyraz.split("");
		String[] znaki_klucz = klucz.split("");
		String wynik = "";
		for (String znak : znaki) {

			if (i_kl + 1 > klucz.length()) {
				pow++;
			}

			i_kl = i_kl % klucz.length();

			if (!(znak.contains(",") || znak.contains("."))) {
				int int_znak = Arrays.asList(alfabet).indexOf(znak);
				int int_znak_klucz = Arrays.asList(alfabet).indexOf(znaki_klucz[i_kl]);
				int temp = (int_znak + int_znak_klucz) % 26;
				wynik += alfabet[temp];
				i_kl++;
			} else
				wynik += znak;
		}

		return wynik + " ";
	}

	public static void zad1() throws FileNotFoundException {
		String klucz = "LUBIMYCZYTAC";
		Scanner s1 = new Scanner(new File("dokad.txt"));
		String linia = s1.nextLine();
		String[] split = linia.split(" ");
		for (String wyraz : split) {
			System.out.print(szyfrowanie(wyraz, klucz));
		}
		System.out.println(" ");
		System.out.println(pow);
		s1.close();
	}

	public static String deszyfrowanie(String wyraz, String klucz) {
		String[] znaki = wyraz.split("");
		String[] znaki_klucz = klucz.split("");
		String wynik = "";
		for (String znak : znaki) {
			i_kl2 = i_kl2 % klucz.length();

			if (!(znak.contains(",") || znak.contains("."))) {
				int int_znak = Arrays.asList(alfabet).indexOf(znak);
				int int_znak_klucz = Arrays.asList(alfabet).indexOf(znaki_klucz[i_kl2]);
				int temp = (int_znak - int_znak_klucz);
				if (temp < 0)
					temp += 26;
				wynik += alfabet[temp];
				i_kl2++;
			} else
				wynik += znak;
		}

		return wynik + " ";
	}

	public static void zad2() throws FileNotFoundException {
		Scanner s = new Scanner(new File("szyfr.txt"));
		String linia = s.nextLine();
		String klucz = s.nextLine();
		String[] split = linia.split(" ");
		for (String wyraz : split) {
			System.out.print(deszyfrowanie(wyraz, klucz));
		}
		System.out.println(" ");
		s.close();
	}

	public static void zad3() throws FileNotFoundException {
		Scanner s = new Scanner(new File("szyfr.txt"));
		String linia = s.nextLine();
		int litery[] = new int[26];
		for (int i = 0; i < linia.length(); i++) {
			if (Character.isLetter(linia.charAt(i))) {

				int j = linia.charAt(i) - 'A';
				litery[j]++;

			}
		}
		int n=0;
		for (int i = 0; i < 26; i++) {
			System.out.print(alfabet[i]);
			System.out.print(":" + litery[i] + "|");
			n+=litery[i];
		}
		
		
		
		double d=0.00;
		double temp=0.00;
		for(int i=0;i<26;i++) {
			temp+=litery[i]*(litery[i]-1);
		}
		double ko=(temp)/(n*(n-1));
		d=0.0285/(ko-0.0385);
		
		
		System.out.println(" ");
		System.out.println("d: "+d);
		linia=s.nextLine();
		System.out.println("Rzeczywista dlugosc: "+linia.length());
		s.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Zad1");
		zad1();
		System.out.println("Zad2");
		zad2();
		System.out.println("Zad3");
		zad3();
	}

}
