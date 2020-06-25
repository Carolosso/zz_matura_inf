package zad66;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class zad66 {
	
	
	public static boolean zad_4(int a,int b,int c) {				
		// sprawdzamy czy 3 liczby spelniaja zaleznosc trojkata 													
		if((a+b>c)&&(b+c>a)&&(a+c>b)) return true;
		else return false;	
	}
	
	public static boolean zad_3(String string) {
		// pobieramy linie i zamieniamy ja na liczby typu int 
		String[] split=string.split(" ");
		String liczba1=split[0]; String liczba2=split[1]; String liczba3=split[2];	
		int a=Integer.parseInt(liczba1);
		int b=Integer.parseInt(liczba2);
		int c=Integer.parseInt(liczba3);
		// sprawdzamy czy liczby moga byc trojkatem prostokatnym na podstawie tw.Pitagorasa
		if((Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2))||(Math.pow(a, 2)+Math.pow(c, 2)==Math.pow(b, 2))||(Math.pow(b, 2)+Math.pow(c, 2)==Math.pow(a, 2))) return true;
		else return false;	
	}
	
	public static boolean zad_2(int a,int b,int c) {
		// sprawdzamy zaleznosc podana w zadaniu
		if(czy_pierwsza(a)==true && czy_pierwsza(b)==true && a*b==c) return true;
		else return false;	
	}
	
	
	public static boolean czy_pierwsza(int liczba) {
		// sprawdzamy czy liczba jest pierwsza
		if(liczba<2)return false;
		for(int i=2;i<=liczba/2;i++) {
			if(liczba%i==0) return false;
			else continue;
		}
		return true;
		
	}
	
	public static int suma_cyfr(int[] liczba) {
		// liczymy sume cyfr podanej liczby
		int suma = 0;
		for(int i=0;i<liczba.length;i++) {
			suma+=liczba[i];			
		}
		
		return suma;
		}
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner s1=new Scanner(new File ("trojki.txt")); Scanner s2=new Scanner(new File ("trojki.txt"));

		System.out.println("Zad 1.");
		while(s1.hasNextLine())
		{
			String linia=s1.nextLine();
			String[] split=linia.split(" ");
			String liczba1=split[0]; String liczba2=split[1]; String liczba3=split[2];
			String[] Cyfry1=liczba1.split(""); String[] Cyfry2=liczba2.split("");
			// zamiana cyfr z liczby1 i liczby2 na typ int
			int []cyfry1 = Arrays.asList(Cyfry1).stream().mapToInt(Integer::parseInt).toArray();
			int []cyfry2 = Arrays.asList(Cyfry2).stream().mapToInt(Integer::parseInt).toArray();
			// zamiana liczby3 na typ int
			int Liczba3=Integer.parseInt(liczba3);
			// suma cyf dowch pierwszych liczb
			int suma=suma_cyfr(cyfry1)+suma_cyfr(cyfry2);
			// sprawdzenie czy zachodzi warunek podany w zadaniu
			if(suma==Liczba3)System.out.println(linia);
			
		}
		System.out.println(" ");
		
		System.out.println("Zad 2.");
		while(s2.hasNextLine())
		{
			String linia=s2.nextLine();
			String[] split=linia.split(" ");
			String liczba1=split[0]; String liczba2=split[1]; String liczba3=split[2];	
			// zamiana liczb na typ int
			int Liczba1=Integer.parseInt(liczba1);
			int Liczba2=Integer.parseInt(liczba2);
			int Liczba3=Integer.parseInt(liczba3);
			// sprawdzenie warunku z zadania
			if(zad_2(Liczba1,Liczba2,Liczba3))System.out.println(linia);

		}
		System.out.println(" ");
		
		System.out.println("Zad 3.");
		Scanner s3=new Scanner(new File ("trojki.txt"));
		// przypisanie do stara_linia liczb nie spelniajacych tw.Pitagorasa
		String stara_linia="0 1 0";
		while(s3.hasNextLine())	
		{
	
			String nowa_linia=s3.nextLine();
			// sprawdzenie czy linia aktualna i poprzednia spelnia warunek
			if(zad_3(nowa_linia) && zad_3(stara_linia))
				{
				// jesli tak to je wypisz
				System.out.println(stara_linia);System.out.println(nowa_linia);
				}
				
			// zapisanie aktualnej linii do poprzedniej
			stara_linia=nowa_linia;
				
		}
		System.out.println(" ");
		
		System.out.println("Zad 4.");
		Scanner s4=new Scanner(new File ("trojki.txt"));
		
		int wiersze=0,ciag=0,ciag_max=0;
		while(s4.hasNextLine())
		{
			String linia=s4.nextLine();
			String[] split=linia.split(" ");
			String liczba1=split[0]; String liczba2=split[1]; String liczba3=split[2];	
			int Liczba1=Integer.parseInt(liczba1);
			int Liczba2=Integer.parseInt(liczba2);
			int Liczba3=Integer.parseInt(liczba3);
			// sprawdzenie warunku z zadania
			if(zad_4(Liczba1,Liczba2,Liczba3))
				{
				// jesli tak to zwieksz liczbe wierszy i dlugosc ciagu
				wiersze++;
				ciag++;
				}
			// jesli nie spelnia warunku to zresetuj wartosc ciagu 
			else ciag=0;
			// sprawdzenie czy aktualny ciag jest wiekszy od najdlujzszego
			if(ciag>ciag_max)ciag_max=ciag;
		}
		System.out.println("Ilosc wierszy: "+wiersze);
		System.out.println("Najdluzszy ciag: "+ciag_max);
		System.out.println(" ");
			
		s1.close();s2.close();s3.close();s4.close(); // zamykamy scannery
	}

}
