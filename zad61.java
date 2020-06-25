package zad61;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class zad61 {

	
	static boolean czy_szescian(int liczba)							// funkcja sprawdzajaca szescian liczby
	{
		 for(int x = 1; x <= 100; x++) {
			 if (x*x*x == liczba)return true;		  
		 }
		 return false;
	} 
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan1= new Scanner(new File("ciagi.txt"));	Scanner scan2= new Scanner(new File("bledne.txt"));	//obiekty skanowania plikow
		int r_max=0,r=0,ilosc=0;																				//zmienne
		int[] ciag= new int[1000];int[] r_tab= new int[991];													//tablice
				
		System.out.println("Zad.2");
		for(int i=1;i<201;i++) {																// petla dla pliku ciagi.txt
			int szescian_max=0,szescian;
			String linia=scan1.nextLine();														//podzial lini
			String[] podzielona = linia.split(" ");
			
			if(podzielona.length>1){															//warunek dla linii o dlugosci >1
				for(int j=0;j<podzielona.length;j++) {	
					ciag[j]=Integer.parseInt(podzielona[j]);									//zamiana na typ calkowity i zapis do tablicy
					if(czy_szescian(ciag[j])) {													//wywolanie funkcji sprawdzajacej szescian liczby
										szescian = ciag[j];
										if(szescian>szescian_max)szescian_max=szescian;			//znajdowanie najwiekszego szescianu danego ciagu			
					}
				}
				if(szescian_max != 0)System.out.println(szescian_max);							//wypisanie tych szescianow roznych od 0
				
				r = ciag[1] - ciag[0];															//dwoch pierwszych wyrazow ciagu
				boolean czy_arytm = true;
				for(int x = 0; x+1 < podzielona.length; x++)									//sprawdzanie ciagu pod katem arytmicznosci
				 if (ciag[x+1] - ciag[x] != r)
				 {
					 czy_arytm = false;
					 break;
				 } 
				if (czy_arytm)																	//obliczanie najwiekszej roznicy 
				{
				 ilosc++;
				 if (r>r_max)
				 r_max = r;
				} 
				
				
			}
			
		}
		
		System.out.println("Zad.3");
		for(int i=1;i<41;i++) {															//petla dla pliku bledy.txt
			String linia=scan2.nextLine();
			String[] podzielona = linia.split(" ");										
			
			if(podzielona.length>1){
				for(int j=0;j<podzielona.length;j++) {
					ciag[j]=Integer.parseInt(podzielona[j]);
				}				
				for(int x = 0; x+1 < podzielona.length; x++)							
				{ 																		//znajdowanie bledu w ciagu
					r_tab[x] = ciag[x+1] - ciag[x];										//zapisywanie roznic do tablicy
					if (r_tab[x] != r_tab[0])
					{
					 System.out.println(ciag[x+1]);
					 break;
					} 
				}
	
			}
			
			
		}
		
		scan1.close();scan2.close();
		System.out.println("Zad.1");
		System.out.println("Liczba ciagow arytmetycznych: "+ilosc);
		System.out.println("Najwieksza roznica ciagu: "+r_max);
		
	}
}

