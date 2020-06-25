package zad67;

import java.util.Scanner;

public class zad67 {
		
	public static int ost_ciag_fibo (int n) {
		//funkcja zwracajaca ostatni wyraz ciag fibnac dla n wyrazow
		int[] ciag=new int [n];
		ciag[0]=1;ciag[1]=1;
		for(int i=2;i<ciag.length;i++) {
			ciag[i]=ciag[i-1]+ciag[i-2];
		}
		return ciag[n-1];
	}
	
	public static int[] ciag_fibo (int n) {
		//funkcja zwracajaca caly ciag fibnac
		int[] ciag=new int [n];
		ciag[0]=1;ciag[1]=1;
		for(int i=2;i<ciag.length;i++) {
			ciag[i]=ciag[i-1]+ciag[i-2];
		}
		return ciag;
	}
	
	
	public static boolean czy_pierwsza(int Fn) {
		//sprawdzamy czy liczba jest pierwsza
		if(Fn<2)return false;
		for(int i=2;i<Fn/2;i++)
		{
			if(Fn%i==0)return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Zad 1."); 
      //sprawdzamy dla n=10,20,30,40 ile wynosi jego wartosc
        for(int n=1;n<=4;n++)
        {
        	int n2=n*10;
            System.out.println(ost_ciag_fibo(n2));
        }
        
        System.out.println("");  
        System.out.println("Zad 2.");  
      //szukanie liczb pierwszych w ciagu fibonacc
        for(int i=3;i<=40;i++)
        {
        	int liczba=ost_ciag_fibo(i);
        	if(czy_pierwsza(liczba))System.out.println(liczba); 
        }
        System.out.println("");
        
        System.out.println("Zad 3 a). ");
        int[] ciag_i=ciag_fibo(40);
        String[]ciag_s=new String[40];
      //zapisujemy do tablicy binarne wartosci ciagu
        for(int i=0;i<ciag_i.length;i++)
        {
        	ciag_s[i]=Integer.toBinaryString(ciag_i[i]);
    		System.out.println(ciag_s[i]);

        }
        System.out.println("");

        System.out.println("Zad 3 b). ");
        Scanner scan=new Scanner(System.in);
        System.out.println("Podaj dlugosc ciagu: ");
        int n = scan.nextInt();
        int[] ciag_i_3=ciag_fibo(n);
        String[]ciag_s_3=new String[n];
        int[] c;
        c=ciag_fibo(n);
        int najdl=c.length;
      //zapisujemy do tablicy binarne wartosci ciagu
        for(int i=0;i<ciag_i_3.length;i++)
        {
        	ciag_s_3[i]=Integer.toBinaryString(ciag_i_3[i]);
        	while (ciag_s_3[i].length()<najdl) ciag_s_3[i] = "0" + ciag_s_3[i]; 
    		System.out.println(ciag_s_3[i]);

        }   
        System.out.println("");
        
        System.out.println("Zad 4."); 
        int[] ciag_i_2=ciag_fibo(40);
        String[]ciag_s_2=new String[40];
      //zapisujemy do tablicy binarne wartosci ciagu
        for(int i=0;i<ciag_i.length;i++)
        {
        	ciag_s_2[i]=Integer.toBinaryString(ciag_i_2[i]);
        	
        }
      //sprawdzamy kazda cyfre czy jest '1'
        for(int i=0;i<ciag_s_2.length;i++)
        {
        	int jedynki =0;
        	String[] split=ciag_s_2[i].split("");
        	for(int j=0;j<split.length;j++) {
        		if(split[j].charAt(0)=='1')jedynki++;
        		
        	}
        	if(jedynki==6)System.out.println(ciag_s_2[i]);
        }
     scan.close();  
	}	

}
