package zad72;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class zad72 {
 
	private static boolean zad1(String linia) {
		//bierzemy linie i dzielimy
		String[] split=linia.split(" ");
		String wyraz1=split[0];String wyraz2=split[1];
		//jesli dlugosc 1 jest wiekszy niz 3krotnosc drugiego albo na odwrot to zworc prawda
		if(wyraz1.length()>=3*wyraz2.length()||wyraz2.length()>=3*wyraz1.length())return true;
		return false;
	}
	private static void zad2(String linia) {
		String dopisane;
		//bierz linie i podziel
		String[] split=linia.split(" ");
		String wyraz1=split[0];String wyraz2=split[1];
		//jesli wyraz2 zaczyna sie wyrazem1
		if(wyraz2.startsWith(wyraz1)) {
			//zapisz do zmiennej to co zostalo z zamiany wyrazu1 na ""
			dopisane = wyraz2.replaceFirst(wyraz1, "");
			//zapisanie do tablicy znakow
			char[] litery=dopisane.toCharArray();
			System.out.println(wyraz1+" "+wyraz2+" Litery: "+Arrays.toString(litery));
		}
	}
	
	private static void zad3() throws FileNotFoundException {
		System.out.println("Zad 3.");
		Scanner s3=new Scanner(new File("napisy.txt"));
		int max=0;
		String[]pary=new String[100];//tablica par 100 bo dwa w jednej komorce
		int x=0;
		while(s3.hasNextLine()) {
			String liniaa=s3.nextLine();//bierzemy linie i dzielimy
			String[] split=liniaa.split(" ");
			int liter=0;
			//podzielone wyrazy do tablicy znakow
			char[] wyraz1=split[0].toCharArray();char[] wyraz2=split[1].toCharArray();
			//dopoki ostatnie litery sie zgadzaja
			while(wyraz1[wyraz1.length-(liter+1)]==wyraz2[wyraz2.length-(liter+1)]) {
				liter++;
			}
			//zapisaywanie wartosci max
			if(liter>max) {
				//zerowanie tablicy
				Arrays.fill(pary, null);	
				max=liter;
				//zapisanie pary
				pary[x]=liniaa;
				x++;
			}
			else if(liter==max) {
				//zapisanie pary
				pary[x]=liniaa;
				x++;
			}
			
		}
		
		System.out.println(max);
		//dal kazdej pary wypisz pare
		for(String para:pary) {
			if(para!=null)
			System.out.println(para);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			System.out.println("Zad 1.");
			Scanner s1=new Scanner(new File("napisy.txt"));	Scanner s2=new Scanner(new File("napisy.txt"));
			int wiersze1=0;
			//liczba wierszy
			boolean temp=true;	//szybki boolean
			while(s1.hasNextLine()) {	//dla kazdego wiersza
				String linia=s1.nextLine(); //zapis do linii
				if(zad1(linia)) {	// jesli linia spelnia zad1 to wypisz
					if(temp)System.out.println("Pierwsza znaleziona para: "+linia);
					wiersze1++;
				}
				temp=false; //szybki boolean konczy zadanie
			}
			System.out.println("Wiersze: "+wiersze1);
			System.out.println("");
			System.out.println("Zad 2.");
			while(s2.hasNextLine()) {
				String linia=s2.nextLine();
				zad2(linia);
			}
			System.out.println("");
			zad3();
	}

}
