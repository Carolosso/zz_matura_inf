package zad74;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class zad74 {
	
	//sprawdzenie czy znak hasla jest mala litera
	private static boolean mala(String haslo) {
		char[] t=haslo.toCharArray();
		for(char znak:t) {
			if(Character.isLowerCase(znak))return true;
		}
		return false;
	}
	//sprawdzenie czy znak hasla jest duza litera
	private static boolean duza(String haslo) {
		char[] t=haslo.toCharArray();
		for(char znak:t) {
			if(Character.isUpperCase(znak))return true;
		}
		return false;
	}
	//sprawdzenie czy znak hasla jest cyfra
	private static boolean cyfra(String haslo) {
		char[] t=haslo.toCharArray();
		for(char znak:t) {
			if(Character.isDigit(znak))return true;
		}
		return false;
	}
	
	private static boolean zad3(String haslo) {
		char[] t=haslo.toCharArray();
		//zad 3 jezeli dlugosci jest mniejsza od 4 zwroc falsz 
		if(haslo.length()>=4) {
			//jesli nie to sprawdz dany fragment 4 znakow czy jest kolejnymi znakami ASCII
				for(int i=3;i<haslo.length();i++) {
					if(czykolej(t[i-3],t[i-2],t[i-1],t[i]))return true;
				}
		}
		else return false;
		return false;
	}
	//sprawdzamy kolejnosc
	private static boolean czykolej(char znak1,char znak2,char znak3,char znak4) {
		//zapisujemy i sortujemy znaki w tablicy
		char[] znaki= {znak1,znak2,znak3,znak4};
		Arrays.sort(znaki);
		//sprawdzamy czy sa kolejnymi znakami
		if(znaki[0]+1==znaki[1] && znaki[1]+1==znaki[2] && znaki[2]+1==znaki[3])return true;
		return false;
	}
	
	//sprawdzenie czy haslo jest zlozone z samych cyfr
	private static boolean cyfry(String haslo) {
		char[] t=haslo.toCharArray();
		ArrayList<Character> cyfry = new ArrayList<>();
		cyfry.add('1');
		cyfry.add('2');
		cyfry.add('3');
		cyfry.add('4');
		cyfry.add('5');
		cyfry.add('6');
		cyfry.add('7');
		cyfry.add('8');
		cyfry.add('9');
		cyfry.add('0');
		for(char znak:t) {
			if(!cyfry.contains(znak))return false;
		}
		return true;
	}
	
	private static void zad2() throws FileNotFoundException {
		//tworzymy dwie listy przechowujace hasla
		ArrayList<String> hasla = new ArrayList<>();
		ArrayList<String> hasla2 = new ArrayList<>();
		Scanner s2= new Scanner(new File("hasla.txt"));
		int licznik = 0;
		//sprawdzamy kazdy wiersz
		while(s2.hasNextLine()) {
			String linia= s2.nextLine();
			//jesli lista zawiera juz nasze aktualne haslo znaczy ze ktos go juz uzywa co najmnije 2 razy
			if(hasla.contains(linia)) {
				licznik++;
				//i dodajemy je do listy2
				hasla2.add(linia);
			}
			//zapisujemy haslo
			else hasla.add(linia);
		}
		//sortujemy powtarzajace sie hasla
		Collections.sort(hasla2);
		System.out.println("Liczba hasel uzywanych przez conajmniej 2 uzytk: "+licznik);
		System.out.println("Hasla: "+hasla2);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s1= new Scanner(new File("hasla.txt"));
		int licznik1=0,licznik2=0,licznik3=0;
		//dla kazdego wiersza
		while(s1.hasNextLine()) {
			String linia= s1.nextLine();
			//sprawdzamy czy sklada sie z samych cyfr
			if(cyfry(linia))licznik1++;
			//sprawdzamy zalozenia z zad4
			if(cyfra(linia)&&mala(linia)&&duza(linia))licznik2++;
			if(zad3(linia))licznik3++;
		}
		System.out.println("Zad 1.");
		System.out.println("Hasel zlozonych z 0-9: "+licznik1);
		System.out.println(" ");
		System.out.println("Zad 2.");
		zad2();
		System.out.println(" ");
		System.out.println("Zad 3.");
		System.out.println("Hasla z fragmentem ASCII: "+licznik3);
		System.out.println(" ");
		System.out.println("Zad 4.");
		System.out.println("Hasla spelniajace wymagania: "+licznik2);
	}

}
