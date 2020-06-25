package zad65;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class zad65 {
	
		static boolean mniejszy(long l1, long m1, long l2, long m2){			//sprowadzanie do wspolnego mianownika aby uniknac bledow 
		 	return (l1*m2<l2*m1);
		}
	
		static boolean rowny(long l1, long m1, long l2, long m2){
			return (l1*m2==l2*m1);
		} 
		
		static int nwd(int n, int m){			//algorytm Euklidesa  do wyznaczenia najwiekszego wspolnego dzielnika

			 if (m==0) return n;
			 return nwd(m,n%m);
			} 

	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(new File("dane_ulamki.txt")); //obiekt skanujace
		int[] liczniki=new int [1000];						//tablice zapisujace liczniki i mianowniki
		int[] mianowniki=new int [1000];
		
		for(int i=0;i<1000;i++) {														//zapis do tablic
			String linia=s.nextLine(); String podzielona[]=linia.split(" ");    		//zapis lini i jej podzielenie
			int liczba1=Integer.parseInt(podzielona[0]); int liczba2=Integer.parseInt(podzielona[1]);	//zamiana z typu string na int
			liczniki[i]=liczba1; mianowniki[i]=liczba2;				//zapisanie do tablicy
			
		}
		 int minL, minM,mniejsza, j, ileN=0;		//utworzenie zmiennych
		 boolean czyN;								//czy nieskracalny
		 long d, sumL=0,mianS, liczS=0, nowyLicz;
		 
		 mianS=2*3*5*7*13;
		 mianS=mianS*mianS/13;
		 minL=liczniki[0];
		 minM=mianowniki[0];
		 
		 for(int i=1; i<1000; i++){
			 
		 if (mniejszy(liczniki[i],mianowniki[i],minL,minM))					//wyszukiwanie ulamka o najmniejszej wartosci i mianowniku
		 {
		 minL=liczniki[i]; minM=mianowniki[i];
		 }
		 else if (rowny(liczniki[i],mianowniki[i],minL,minM))
		 {
			 if (mianowniki[i]<minM)
			 {
			 minL=liczniki[i]; minM=mianowniki[i];
			 }
		 }
		 
		 if (liczniki[i-1]<mianowniki[i-1]) mniejsza = liczniki[i-1];		//sprawdzenie czy ulamek jest nieskracalny
		 else mniejsza = mianowniki[i-1];
		 	j=2; czyN = true;
		 while (j<=mniejsza){
			 if ((liczniki[i-1]%j==0) && (mianowniki[i-1]%j==0))
			 czyN=false;
			 j++;
		 }
		 if (czyN) ileN++;											//jesli ulamek jest nieskracalny to zwiekszamy licznik
							
		 }
		 
		 for(int i=0;i<1000;i++) {
			 
			d=nwd(liczniki[i],mianowniki[i]);					// algorytmem Euklidesa wyszukujemy dzielniki danego ulamka
			sumL = sumL + liczniki[i]/d;						//i wyznaczamy sume licznikow ulamkow nieskracalnych
			 
			nowyLicz = liczniki[i]*mianS/mianowniki[i];
		    liczS+= nowyLicz;
		 }
		

		 
		 
		 	System.out.println("Zad. 1");
		 	System.out.println("Ulamek o najmniejszej wartosci: "+minL+"/"+minM);
		 	System.out.println("Zad. 2");
		 	System.out.println("Liczba ulamkow w postaci nieskracalnej: "+ileN);
		 	System.out.println("Zad. 3");
		 	System.out.println("Suma licznikow ulamkow nieskracalnych: "+sumL);
		 	System.out.println("Zad. 4");
		 	System.out.println("Licznik ulamka takiego ze suma ulamkow jest rowna a/b: "+liczS);
	}

}
