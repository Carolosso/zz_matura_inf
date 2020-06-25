package zad71;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class zad71 {
	//zaokraglanie do 5 miejsc po przecinku
    private static DecimalFormat df1 = new DecimalFormat("###.#####");
	//zaokraglanie do 3 miejsc po przecinku
    private static DecimalFormat df2 = new DecimalFormat("#.###");
    
	private static double f(double x,int i) throws FileNotFoundException {
		//bierzemy podzielony wiersz i zapisujemy wielomiany do zmiennych double
		Scanner s1= new Scanner(new File("funkcja.txt"));
		double a0 = 0,a1=0,a2=0,a3=0;
		//dla kazdego wiersza
		for(int j=1;j<=i;j++) {
			//bierzemy linie i dzielimy
			String linia=s1.nextLine();
			String[] split=linia.split("\\s+");	
			//wielomiany
			a0=Double.parseDouble(split[1]);
			a1=Double.parseDouble(split[2]);
			a2=Double.parseDouble(split[3]);
			a3=Double.parseDouble(split[4]);
			if(j==i)return (double)a0+a1*x+a2*Math.pow(x, 2)+a3*Math.pow(x, 3); //wyliczamy ze wzoru
		}
		return 0;
	}
	
	private static void zad2() throws FileNotFoundException {
		double max=0.0,x=0.0,maxx=0.0;
		//szukanie x<5
		for(int i=1;i<=5;i++) {
			while(x<5) {
				//zapisujemy najwyzszy argument i wartosc 
				if(f(x,i)>max) {
					
					max=f(x,i);
					maxx=x;
				}
				//przechodzenie do nastepnego przedzialu
				if(x>=i)i++;
				//zwiekszamy x
				x+=0.001;
			}
		}
		System.out.println("y: "+df1.format(max)+" x: "+df2.format(maxx));

	}
	
	private static double bisekcja(double left, double right) throws FileNotFoundException
	{
			for(int i=1;i<=5;i++) {
				double error=0.00001;
				while(right - left > error) {
					 double mid = (left +right)/2.0;
						        if((f(mid,i)) <= error)
						            return mid;
						        else if(f(left,i) * f(mid,i) < 0)
						            right = mid;
						        else
						            left = mid;
					} 
			}
				
		return (double) (left+right)/2.0;
	} 

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//zad 1 wiemy ze i=2 bo x=1,5 jest w tym przedziale
		System.out.println("Zad 1.");
		System.out.println("Wartosc f(1.5): "+df1.format(f(1.5,2)));
		System.out.println("Zad 2.");
		zad2(); 
		System.out.println("Zad 3.");
		System.out.println(bisekcja(0.4, 0.6));
		System.out.println(bisekcja(2.2, 2.75));
		System.out.println(bisekcja(3.1, 3.7));
		System.out.println(bisekcja(4.8, 4.9));
	}

}
