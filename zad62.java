package zad62;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class zad62 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			Scanner s1= new Scanner(new File("liczby1.txt"));Scanner s2= new Scanner(new File("liczby2.txt")); // obiekty skanowania plikow
			int max=0,min=0,s=0,v=0,temp_10=0,temp_8=0,d6=0,o6=0;											// utoworzenie zmiennych
			int tab1_10[]=new int[1000];int tab2_10[]=new int[1000];										// i  tablic
			int tab1_8[]=new int[1000];//String tab2_8[]=new String[1000];									// i  tablic
			
			for(int i=1;i<1001;i++) {												//petla wykonujaca sie dla kazdej linii pliku/tworzenie tablic
																					//
				 String linia1= s1.nextLine();										//pobranie liczby1 do zmiennej
				 tab1_10[i-1]=Integer.parseInt(linia1,8);							//zapisywanie do tab1_10 liczb dziesietnie z plik1
				 tab1_8[i-1]=Integer.parseInt(linia1);								//zapisywanie do tab1_8 liczb osemkowo z plik1
				 String linia2= s2.nextLine();										//pobranie liczby do zmiennej
				 tab2_10[i-1]=Integer.parseInt(linia2);								//zapisywanie do tab2_10 liczb dziesietnie z plik2		
				// tab2_8[i-1]=Integer.toOctalString(tab2_10[i-1]);					//zapisywanie do tab2_10 liczb osemkowo z plik2
			}	
					
			
			for(int i=0;i<1000;i++) {												//petla dla kazdego elementu tablic
				if(tab1_10[i]==tab2_10[i])s++;										//szukanie takich samych elementow
				else if(tab1_10[i]>tab2_10[i])v++;									//roznych elementow
				
				temp_10=tab2_10[i];													//szukanie cyfry 6 w liczbach dziesietnych za pomoca reszty z dzielenia
				while(temp_10>=6){
					if(temp_10%10==6)d6++;
					temp_10/=10;
				}
				temp_8=tab2_10[i];													//szukanie cyfry 6 w liczbach osemkowych
				while(temp_8>=6){
					if(temp_8%8==6)o6++;
					temp_8/=8;
				}
				
			}
			
			 int naj_dlugosc_podciagu = 0;
			 int naj_pierwszy = 0;													 // pierwszy element najdluzszego podciągu
			 int poprzednia = 1000000;
			 int dlugosc_podciagu = 0;												 //dlugosc wykrywanego podciągu
			 for(int i=0; i<1000; i++) {
				 
			 if (tab2_10[i] < poprzednia) {
				 
					 if (dlugosc_podciagu > naj_dlugosc_podciagu) {					// porownanie dlugosci podciagu z dotychczas najdluzszym
						 naj_dlugosc_podciagu = dlugosc_podciagu;
						 naj_pierwszy = tab2_10[0];
					 }
					 
				 tab2_10[0] = tab2_10[i];
				 dlugosc_podciagu = 1;
			 	}	
			 
			 else {
			 dlugosc_podciagu++;													 // kontynuacja podciągu
			 }
			 poprzednia = tab2_10[i];												 // zastapienie poprzedniej biezaca
			 } 
			
			
			Arrays.sort(tab1_8);													 //sortowanie tablicy rosnaco
			max=tab1_8[tab1_8.length-1];											 //pobranie wartosci min max
			min=tab1_8[0];
		
			System.out.println("Zad.1");
			System.out.print("Najwieksza liczba: "+max+"; ");System.out.println("Najmniejsza liczba: "+min); //wypisanie wyniku
			System.out.println("Zad.2");
			System.out.println("Elementow: "+ naj_dlugosc_podciagu+"; "+"Pierwszym elementem jest: "+naj_pierwszy);
			System.out.println("Zad.3");
			System.out.print("Wiersze z takimi samymi wartosciami: "+s+"; ");System.out.println("Wiersze z wieksza wartoscia od liczby2.txt: "+v);//wypisanie wyniku
			System.out.println("Zad.4");
			System.out.print("6 w zapisie osemkowym: "+d6+"; ");System.out.print("6 w zapisie dziesietnym: "+o6);
			s1.close();
			s2.close();
	}

}
