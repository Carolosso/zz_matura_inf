package zad75;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class zad75 {

	private static void zad1() throws FileNotFoundException {
		Scanner tekst=new Scanner(new File("tekst.txt"));
		String linia=tekst.nextLine();
		String[] split=linia.split(" ");
		for(String wyraz:split) {
			char[] znaki=wyraz.toCharArray();
			if(znaki[wyraz.length()-1]=='d'&&znaki[0]=='d')System.out.println(wyraz);
		}
	}

	private static String szyfr(int A,int B,String wyraz) {
		//wyraz do tablicy znakow
		char[]wyr_znak=wyraz.toCharArray();
		//tworzenie tabeli z literami\
	    char[] litery = new char[26];
    	int temp=97; //poniewaz litera 'a' ma wartosc 97 w ASCII
    	//wypelnienie tablicy literami ktore od razu beda mialy przypisana liczbe(czyli indeks)
    	//string wyjsciowy zlozony z tablicy
    	String lit_str="";
	  	for(int i=0;i<=25;i++) {
		   litery[i]=(char)temp;
		   lit_str+=litery[i];
		   temp++;
		  }
	  	//string wynikowy
	  	String wynik="";
  		//dla kazdego znaku danego wyrazu
	  	for(char znak:wyr_znak) {
	  		//pobieramy jego indeks/liczbe w tabeli
	  		int cznak=lit_str.indexOf(znak);
	  		//stosujemy podane instrukcje
	  		cznak=(cznak*A)+B;
	  		//jesli jest wiekszy od 25 to jego wartosc to reszta z dzielenia przez 26
	  		if(cznak>25)cznak=cznak%26;
	  		//zapisujemy do wynikowego stringa znak na obliczonym indeksie w tabeli
	  		wynik+=lit_str.charAt(cznak);
	  	}
	  	//zwracamy wynik
		return wynik;
	}
	private static void zad2() throws FileNotFoundException {
		Scanner tekst=new Scanner(new File("tekst.txt"));
		String linia=tekst.nextLine();
		String[] split=linia.split(" ");
		//dla kazdego wyrazu tekstu
		for(String wyraz:split) {
			//jesli jego dlugosc ma co najmniej 10 znakow to szyfrujemy
			if(wyraz.length()>=10)System.out.println(szyfr(5,2,wyraz));
		}
	}
	private static void zad3() throws FileNotFoundException {
		
		Scanner tekst=new Scanner(new File("probka.txt"));
		int x=0;
		//dla pieciu linii
		while(x<5) {
			///pobieramy i dzielimy
			String linia=tekst.nextLine();
			String[] split=linia.split(" ");
			//zapisujemy wyrazy
			String wyraz1=split[0];String wyraz2=split[1];
			//pomocnicza zmienna bool zatrzymujace petle
			boolean temp=false;
			//dla wszystkich 26x26 mozliwosci zaszyfrowania
			for(int A=0;A<=25;A++) {
				for(int B=0;B<=25;B++) {
						//jesli zaszyfrowany wyraz1 danymi A i B rowna sie zaszyfrowanemu juz wyraz2 
						if(szyfr(A,B,wyraz1).equals(wyraz2)) {
							//to wypisujemy
							System.out.print("Szyfrujacy: A: "+A+" B: "+B+" || ");
						}
						//jesli zaszyfrowany wyraz2 danymi A i B rowna sie jawnemu wyraz1 
						if(szyfr(A,B,wyraz2).equals(wyraz1)) {
							//to wypisujemy
							System.out.print("Deszyfrujacy:A: "+A+" B: "+B); 
							temp=true;
						}	
						if(temp)break;	
						
				}
			}
			x++;
			System.out.println(" ");
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Zad 1.");
		zad1();
		System.out.println("Zad 2.");
		zad2();
		System.out.println("Zad 3.");
		zad3();

	}

}
