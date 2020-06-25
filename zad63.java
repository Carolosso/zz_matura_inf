package zad63;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class zad63 {

	
	public static boolean dwucyklicznosc(String ciag) {
		
		String s1=ciag.substring(0,ciag.length()/2);		//dzielenie linia na 2 i sprawdzenie czy pierwsza czesc = drugiej
		String s2=ciag.substring(ciag.length()/2);
		if(s1.equals(s2))return true;
		else return false;						
	}
	
	public static boolean czy_nie_wystepuja_jedynki(String ciag) {
		for(int i=0;i<ciag.length()-1;i++)
		{
			if(ciag.contains("11"))return false;			//jesli ciag zawiera "11" czyli jedynki obok siebie
		}
		return true;
	}
	
	public static int czy_pol_pierwsza(int liczba) 
    { 
        int licznik=0; 
        for (int i=2; licznik<2 && i*i <= liczba; i++) 
                       
            while (liczba % i == 0)
            { liczba /= i; 
            licznik++; 										 // zwieksz licznik liczb pol pierwszych
            } 
        if (liczba > 1) licznik++; 						    // jesli liczba jest wieksza od 1 zwieksz licznik  
        
        return licznik == 2 ? 1 : 0; 						// zwroc 1 jesli licznik = 2 jesli nie to zwroc 0
    } 
      
    static boolean polpierwsza(int n) 
    { 
        if (czy_pol_pierwsza(n) != 0) 
            return true;
        else
            return false;
    } 
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s1=new Scanner(new File("ciagi.txt")); //obiekty skanujace
		Scanner s2=new Scanner(new File("ciagi.txt"));
		Scanner s3=new Scanner(new File("ciagi.txt"));
		System.out.println("Zad 1.");
		for(int i=0;i<1000;i++) {					
	
			String linia=s1.nextLine();
			if(dwucyklicznosc(linia))System.out.println(linia);
			
		}
		System.out.println("Zad 2.");
		int jedynki=0;
		for(int i=0;i<1000;i++) {
			
			String linia=s2.nextLine();
			if(czy_nie_wystepuja_jedynki(linia))jedynki++;
			
		}
		System.out.println(jedynki);
		System.out.println("Zad 3.");
		long ile=0;
		for(int i=0;i<1000;i++) {
			String linia=s3.nextLine();						
			int liczba= Integer.parseInt(linia,2);	//zamiana na dziesietna liczbe
			if(polpierwsza(liczba))ile++;
						
		}
		System.out.println("Ilosc ciagow: "+ile);
		s1.close();s2.close();s3.close();
	}

}
