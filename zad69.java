package zad69;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class zad69 {
	
	public static boolean palindrom(String genotyp) {
		//sprawdzenie czy jest palindromem
		char[] litery=genotyp.toCharArray();
		int i1 = 0;
		int i2 = genotyp.length() - 1;
		while (i2 > i1) {
			if (litery[i1] != litery[i2]) {
			return false;
		}
			++i1;
			--i2;
		}
		    return true;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s1=new Scanner(new File("dane_geny.txt"));
		//tworzymy tablice zawieraca linie/genotypy
		String [] genotypy=new String [1000];
		//tworzymy tablice zawieraca dlugosci genotypu
		int [] dlugosci=new int [500];
		//wypelniamy zerami
		Arrays.fill(dlugosci, 0);
		//wypelniamy tablice genotypy genotypami
		int x=0;
		while(s1.hasNextLine()) {
			String genotyp=s1.nextLine();
			genotypy[x]=genotyp;
			x++;
		}
		System.out.println("Zad 1.");
		//dla kazdej z dlugosci genotypu zwiekszamy wartosc jego pozycji w tablicy dlugosci(jest to rownoznaczne z liczba osobnikow danego gatunku 
		for(int i=0; i<1000; i++){
			 dlugosci[genotypy[i].length()]++;
			 } 
		//sortujemy dlugosci rosnaco
		Arrays.sort(dlugosci);
		//wypisujemy ostatni wyraz czyli najwiekszy bedacy wynikiem
		System.out.println("Najwiekszy gatunek liczy: "+dlugosci[dlugosci.length-1]+" osobnikow.");
		int gatunki =0;
		//jesli liczba osobnikow jest wieksza od 0 to jest gatunek
		for(int i=0; i<500; i++){
			
			if(dlugosci[i]>0)gatunki++;
		}
		System.out.println("Liczba wszystkich gatunkow: "+gatunki);
		System.out.println(" ");
		
		System.out.println("Zad 2.");
		Scanner s2=new Scanner(new File("dane_geny.txt"));
		int mutacje=1,gen_max=0,dl_genu=0,silnieodp=0,odp=0;
		//dla kazdej lini/genotypu/osobnika
		while(s2.hasNextLine()) {
			boolean temp=false;
			//liczba genow =0 na poczatku dla kazdej lini
			int genow=0;
			String genotyp=s2.nextLine();
			String genotyp_odwrocony= new StringBuffer(genotyp).reverse().toString();
			//jezeli genotyp jest palindromem to silnie odporny i nie bierzemy go pod uwage dla  odpornego
			if(palindrom(genotyp)||palindrom(genotyp_odwrocony)) {
				silnieodp++;
				temp=true;
			}
			String[] geny=new String[genotyp.length()/2];//tworzymy tablice z genami 
			String[] geny2=new String[genotyp.length()/2];//tworzymy tablice z genami 

			x=0;
			//petla "nieskonczona"
			while(true) {
				//zapisujemy do zmiennych pozycje poczatku i konca genu
				int start=genotyp.indexOf("AA"); int koniec=genotyp.indexOf("BB",start+2);//+2 aby pominac "AA"
				int start2=genotyp_odwrocony.indexOf("AA"); int koniec2=genotyp_odwrocony.indexOf("BB",start2+2);//+2 aby pominac "AA"

				//jesli nie znajdzie to przerwij petle
				if(start==-1||koniec==-1||start2==-1||koniec2==-1)break;
				else {
					//to do stringa gen zapisz znaleziony gen
						String gen=genotyp.substring(start, koniec+2);//+2 aby pominac "BB"
						String gen2=genotyp_odwrocony.substring(start2, koniec2+2);//+2 aby pominac "BB"

						//zapisujemy gen do tablicy genow
						geny[x]=gen;
						geny2[x]=gen2;
						//szukanie najdluzszego genu
						if(geny[x].length()>dl_genu)dl_genu=geny[x].length();
						//jezeli gen zawiera "BCDDC" to jest to mutacja
						if(geny[x].contains("BCDDC"))mutacje++;
						//do zmiennej genotyp zapisujemy nowy genotyp bez znalezionego genu
						genotyp=genotyp.substring(koniec+2);
						genotyp_odwrocony=genotyp_odwrocony.substring(koniec2+2);
						x++;
					}
				//jesli petla sie wykona to znaleziono gen
				if(true)genow++;
			}
			//szukanie najwiekszej liczby genow u osobnika
			if(genow>gen_max)gen_max=genow;
			
			//jesli nie jest silnie odporny to sprawdzamy czy zawiera takie same geny
			if(temp==false) {
				if(Arrays.equals(geny, geny2))odp++;
			}
		}
		System.out.println("Liczba mutacji w genach: "+mutacje);
		System.out.println(" ");

		System.out.println("Zad 3.");
		System.out.println("Najwieksza liczba genow: "+gen_max);
		System.out.println("Dlugosc najdluzszego genu: "+dl_genu);
		System.out.println(" ");

		System.out.println("Zad 4.");
		System.out.println("Liczba silnie odpornych genotypow: "+silnieodp);
		System.out.println("Liczba odpornych genotypow: "+odp);

		s1.close();s2.close();

	}

}
