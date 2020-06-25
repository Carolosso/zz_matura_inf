package zad28;

import java.util.Arrays;
import java.util.Scanner;

public class zad28 {

	public static boolean czyApali(String slowo) {
		//musi byc spelniony jeden z 2 warunkow
		int m=slowo.length();
		char[] aa=new char[m];
		char[] slowochar=new char[m];
		slowochar=slowo.toCharArray();
		Arrays.fill(aa,0, m,'A');
		//1 warunek
		boolean warunek1=false;
		for(int i=0;i<m;i++) {
			if(slowochar[i]!=aa[i])warunek1=false;
		}
		//koniec warunku1
		
		//2 warunek
		boolean warunek2=false;
		if(m>2) {
		if(m%2==0) {
			//warunek2a
			boolean warunek2a=false;
			if(slowochar[0]==slowochar[m-1])warunek2a=true;
			//warunek2b
			boolean warunek2b=false;
			String wyraz1=slowo.substring(0, m/2);
			String wyraz2=slowo.substring(m/2, m);
			//sprawdzanie czy ktoras z czesci slowa jest slabym a-palindromem
			if(czyApali(wyraz1)||czyApali(wyraz2))warunek2b=true;
			//jesli oba warunki podrzedne sa spelnione to glowny warunek 2 jest spelniony
			if(warunek2a&&warunek2b)warunek2=true;
		} 
		else warunek2=false;
		}
		else {
			//warunki na sztywno dla m<2
			if(slowo.contains("AA")||slowo.contains("BB"))return true;
			else warunek2=false;
		}
		//jesli ktorys z 2 warunkow glownych jest spelnionych to zwroc prawda
		if(warunek1||warunek2)return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1=new Scanner(System.in);
		String slowo=s1.nextLine();
		System.out.println("Czy "+slowo+" jest slabym A-palindromem? "+czyApali(slowo)); 
	}

}
