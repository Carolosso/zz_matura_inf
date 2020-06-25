package zad60;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class zad60 {
	
	/*
	public static  int nwd(int x, int y) // algorytm Euklidesa
    {
     if (x < y) { return nwd(y,x);}
     else if (y == 0) {return x;}
     else {return nwd(y,x%y);}
    }
	*/
	public static int nwd(int a ,int b) {
		if(a%b==0) return b;
		else return nwd(b,a%b);
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file= new File("liczby.txt");
		Scanner plik= new Scanner(new File("liczby.txt"));Scanner plik2= new Scanner(new File("liczby.txt"));
		int liczba,ostatnia1=0,ostatnia2=0,licznik = 0,dzielniki=0,wzglednie_max=0;
		int [] liczby= new int [200];
		
		for(int i=0;i<200;i++) {
			liczba=plik.nextInt();
			liczby[i]=liczba;
		}
	
		System.out.print("2. ");
		
		for(int i=0;i<200;i++) {
			liczba=plik2.nextInt();
			dzielniki=0;
			//liczby[i]=liczba;
			boolean czy= true;
			
			for(int x=0; x<200; x++) {
            if (i !=x && nwd(liczby[i],liczby[x])>1)czy = false;
              }
			if (czy && liczby[i] > wzglednie_max)
            	wzglednie_max = liczby[i];	
			
			for(int j=1;j<=liczba;j++) {
				if(liczba%j==0)dzielniki++;
				
			}
			if(dzielniki==18) {
				System.out.println("");System.out.println(liczba);
				for(int j=1;j<=liczba;j++) {
					if(liczba%j==0)System.out.print(j+" ");
				}
			}
			if(liczba<1000) {
				licznik++;
				ostatnia1=ostatnia2;
				ostatnia2=liczba;	
			}
		}
		
		
		System.out.println("");
		System.out.println("1. Liczby mniejsze od 1000: "+licznik);System.out.println("Ostatnie dwie liczby: "+ostatnia1+" i "+ostatnia2);
		System.out.println("3. Najwieksza liczba wzglednie pierwsza: "+wzglednie_max);
		plik.close();plik2.close();
	}
	
}
