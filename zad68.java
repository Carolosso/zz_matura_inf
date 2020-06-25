package zad68;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class zad68 {
	
	public static boolean zad_1(String wyraz1,String wyraz2) {
	
			if(wyraz1.length()!=wyraz2.length())return false; //jesli wyrazy nie maja takiej samej dlugosci to false
			else {
				//zapisujemy wyrazy do tablic znakow/liter
		        char litery1[] = wyraz1.toCharArray(); char litery2[] = wyraz2.toCharArray(); 
		        //sortujemy tablice
		        Arrays.sort(litery1); Arrays.sort(litery2);
		        for(int i=0;i<wyraz1.length();i++) {
		        	//dla kazdej litery wyrazu1
		        	for(int j=0;j<wyraz2.length();j++) {
		        		//sprawdzamy czy nie znajduje sie w wyrazie2
		        		if(litery1[i]!=litery2[j]) return false;
		        	}
		        }
			}
			//jesli wyszystko sie wykona to zwroc true
			return true;		
	}
	
	
	public static boolean anagram(String wyraz1,String wyraz2) {
		
	        char litery1[] = wyraz1.toCharArray(); char litery2[] = wyraz2.toCharArray(); 
	        Arrays.sort(litery1); Arrays.sort(litery2);
	        //sprawdzamy czy zawartosc 
	        boolean czy=Arrays.equals(litery1, litery2);  
	        return czy;		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(new File("dane_napisy.txt")); //obiekt skanujace
		int wiersze=0;
		System.out.println("Zad 1.");
		while(s.hasNextLine())		
		{
			String linia=s.nextLine();
			String[] split=linia.split(" ");
			String wyraz1=split[0];String wyraz2=split[1];
			if(zad_1(wyraz1,wyraz2))
				{wiersze++;
				//System.out.println(linia);
				}		
		}
		System.out.println("Liczba wierszy: "+wiersze);
		wiersze=0;
		System.out.println("");
		Scanner s2=new Scanner(new File("dane_napisy.txt")); //obiekt skanujace
		System.out.println("Zad 2.");
		
		String[]linie=new String[1000];
		int v=0;
		while(s2.hasNextLine())		
		{
			//przy okazji zapisujemy linie do tablicy linie dla zad3
			String linia=s2.nextLine();
			linie[v]=linia;
			String[] split=linia.split(" ");//dzielimy linie
			String wyraz1=split[0];String wyraz2=split[1];//podzielone zapisujemy do stringow
			if(anagram(wyraz1,wyraz2))wiersze++;//sprawdzamy funkcja
			v++;
		}
		System.out.println("Anagramow: "+wiersze);
		s.close();s2.close();
		System.out.println("");

		Scanner s3=new Scanner(new File("dane_napisy.txt")); //obiekt skanujace
		System.out.println("Zad 3."); 
		int li_max=0; int licznik=0;

		while(s3.hasNextLine())		
		{
			//dla kazdej lini bierzemy ja i dzielimy
			String linia1=s3.nextLine();
			String[] split1=linia1.split(" ");
			for(String wyraz:split1) {//dla kazdego wyrazu/elementu
				//bierzemy linie z zapisanych w tablicy i dzielimy je
				for(String linia:linie) {
					String[] split2=linia.split(" ");
					//i dla kazdego elementu sprawdzamy z pierwszym wybranym
					for(String wyraz2:split2) {
						//jesli sa anagramami to licznik zwiekszamy
	                      if(anagram(wyraz, wyraz2))licznik++;
					}
				}
				//sprawdzamy czy licznik aktualny jest najwiekszy dla danego wyrazu
				if(licznik>li_max)li_max=licznik;
				//po kazdym wyrazie resetujemy licznik
				licznik=0;
			}
		}
		System.out.println("Najwieksza liczba anagramow dla slowa: "+li_max);
		s3.close();
	}
}
