package zad73;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class zad73 {
	private static void zad1() throws FileNotFoundException {
		Scanner s1=new Scanner(new File("tekst.txt"));
		int licznik=0;
		//wczytujemy caly tekst w jednej linii
			String linia=s1.nextLine();
			//dzielimy na wyrazy
			String[] split=linia.split(" ");
			//dla kazdego wyrazu
			for(String wyraz:split) {
				//zamieniamy na tablice znakow/liter
				char[] litery=wyraz.toCharArray();
				//dla kazdej litery sprawdzamy czy rowna sie nastepnej
				for(int i=1;i<litery.length;i++) {
					if(litery[i-1]==litery[i]) {
						//jesli tak to zwiekszamy licznik i dalej nie sprawdzamy tego wyrazu
						licznik++;
						break;
					}
				}
		}
			System.out.println("Zad 1.");
			System.out.println("Liczba slow: "+licznik);
			s1.close();
	}
	
	private static int suma_liter() throws FileNotFoundException {
		Scanner s2=new Scanner(new File("tekst.txt"));
		int suma=0;
		//wczytujemy caly tekst w jednej linii
			String linia=s2.nextLine();
			//dzielimy na wyrazy
			String[] split=linia.split(" ");
			//dla kazdego wyrazu
			for(String wyraz:split) {
				//zamieniamy na tablice znakow/liter
				char[] litery=wyraz.toCharArray();
				for(int i=0;i<litery.length;i++) {
					if(litery[i]!=' ') {
						suma++;
					}
				}
		}
		s2.close();
		return suma;
	}
	
	private static int wystapien(char litera) throws FileNotFoundException {
		Scanner s3=new Scanner(new File("tekst.txt"));
		int ile_razy=0;
		//wczytujemy caly tekst w jednej linii
			String linia=s3.nextLine();
			//dzielimy na wyrazy
			String[] split=linia.split(" ");
			//dla kazdego wyrazu
			for(String wyraz:split) {
				//zamieniamy na tablice znakow/liter
				char[] litery=wyraz.toCharArray();
				for(int i=0;i<litery.length;i++) {
					if(litery[i]==litera) {
						ile_razy++;
					}
				}
		}
		s3.close();
		return ile_razy;
		
	}
	
	private static void zad3() throws FileNotFoundException {
		Scanner s4=new Scanner(new File("tekst.txt"));
		int licznik=0;
		int dl=0;
		int max=0;
		ArrayList<Character> samogloski = new ArrayList<>();
		ArrayList<Character> podslowo = new ArrayList<>();
		ArrayList<String> podslowa = new ArrayList<>();
		samogloski.add('A');
		samogloski.add('E');
		samogloski.add('I');
		samogloski.add('O');
		samogloski.add('U');
		samogloski.add('Y');
		//wczytujemy caly tekst w jednej linii
			String linia=s4.nextLine();
			//dzielimy na wyrazy
			String[] split=linia.split(" ");
			//dla kazdego wyrazu
			String pwyraz="";
			for(String wyraz:split) { 
				dl=0;
				//zamieniamy na tablice znakow/liter;
				char[] litery=wyraz.toCharArray();
				//dla kazdej litery
				for(int i=0;i<litery.length;i++) {
					//sprawdzamy czy jest spolgloska
							if(!samogloski.contains(litery[i])) {
								dl++;
								//jesli najdluzsze dotychczas to zapisujemy
								if(dl>max) {
									max=dl;
									//zapisujemy pierwszy wyraz
									pwyraz=wyraz;
									//czyscimy i dodajemy aktualny wyraz do listy
									podslowa.clear();
									podslowa.add(wyraz);
								}
								//jesli jednak nie ma go w liscie i ma ta sama dlugosc to go dodajemy
								else if(dl==max&&!podslowa.contains(wyraz))podslowa.add(wyraz);
							}
							//jesli nie to dlugosc resetujemy ale sprawdzamy wyraz dalej
							else dl=0;
					}
				
			}
			System.out.println("Zad 3.");
			System.out.println("Dlugosc max podslowa: "+max);
			System.out.println("Pierwsze podslowo: "+pwyraz);
			System.out.println("Liczba slow o takim podslowie: "+podslowa.size());
			s4.close();
		}

			
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		zad1();
		//System.out.println(suma_liter());
		System.out.println(" ");
		System.out.println("Zad 2.");
		for(int i=65;i<=90;i++) {
			char litera=(char)i;
			//ZAD2
			double wynik=(double)wystapien(litera)/suma_liter()*100;
			//zaokraglanie./
			DecimalFormat df = new DecimalFormat("0.00");
	    	df.setRoundingMode(RoundingMode.CEILING);
	    	//wynik
			System.out.println("["+litera+"]"+" "+wystapien(litera)+"  "+df.format(wynik)+"%");
		}
		System.out.println(" ");
		//ZAD3
		zad3();
	}

}
