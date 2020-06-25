package zad70;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class zad70 {
		
		//funkcja f(x)
	public static double f(double x) {
		
	    return (double)( (Math.pow(x,4)/500)-(Math.pow(x,2)/200)-(3.0/250) );
	}
	//funkcja g(x)
	public static double g(double x) {
		
	    return (double)( ( (-Math.pow(x,3)/30)+(x/20)+(1.0/6) ) );
	}
// A = (2, -32 2/3) 	bo x=2 ,od dolu prosta y=-32 2/3
// B = (10, -32 2/3)	bo g(10)=-32 2/3
// C = (10, 19 61/125)  bo f(10)=19 61/125
// D = (2, 19 61/125)	bo x=2 ,od gory prosta y=19 61/125

	private static String zad1() {
		//pole między f(x) i g(x) dla x od 2 do 10
		double ppwyk = 0;		//pole po wykrojeniu
	    double n = 1000000;   	//liczba czesci
	    double h = 8/n;     	//wysokosc jednej czesci
	    int x = 2;     	 //prosta x=2
	    for(int i=0;i<n;i++) {
	    	//obliczenie długosci boku || do osi Y
	        double roznicay = f(x + h * i) - g(x + h * i);
	        //dodajemy do aktualnego pola wyliczona roznice
	        ppwyk += h * roznicay; 
	    }
	    //zaokraglenie do 3 liczb po przecinku
    	DecimalFormat df = new DecimalFormat("#.###");
    	df.setRoundingMode(RoundingMode.CEILING);
    	//wynik
	    return df.format(ppwyk);
	}
	
	private static double zad2() {
		double obwod=16+19+61.0/125+32+2.0/3;
		int n = 1000;      //czesci na ktore podzielono pole
		double h = 8.0/n;  //dlugosc jednej czesci
		int x = 2;         // prosta x=2
		for(int i=0;i<n;i++) {
	        double x0 = x + h * i;  //poczatkowe x
	        double xk = x0 + h;    //x koncowe
	        //odległość punktu f(x1) od f(x2) bedzie dlugoscia
	        double odlegloscF = Math.sqrt(Math.pow(h,2)+ Math.pow((f(xk) - f(x0)),2));
	        double odlegloscG = Math.sqrt(Math.pow(h,2)+ Math.pow((g(xk) - g(x0)),2));
	        //dodanie odleglosci do obwodu
	        obwod += odlegloscF + odlegloscG;
		}
    	//wynik /zaokraglenie do liczby calkowitej
	    return Math.floor(obwod);
	}
	
	private static double zad3() {
		double dlugosc = 0;// suma calkowita pasow
		int x0 = 10;      //poczatkowe x
	    double  h = 0.25;    //dlugosc pojedynczego pasa
		double n = 8.0/h ;  //ilosc pasow na ktora dzielimy material
		for (int i=1;i<n;i++) {			//dlugosc danego fragmentu to punkty skrajne f(x) i g(x) z lewej strony  
			 double x = x0 - h * i;
			 dlugosc +=f(x)-g(x); 	
		}
    	//wynik /zaokraglenie do liczby calkowitej
	    return Math.floor(dlugosc);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter zapis=new PrintWriter("wynik.txt");
		zapis.println("Zad 1.");
		zapis.print("Material po wykrojeniu zaslony: "+zad1());
		zapis.println(" ");
		zapis.println("Zad 2.");
		zapis.print("Dlugosc tasmy do zakupienia: "+zad2());	
		zapis.println(" ");
		zapis.println("Zad 3.");
		zapis.print("Suma dlugosci pasow do wyciecia: "+zad3());
		zapis.close();
	}

}
