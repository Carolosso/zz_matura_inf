package zad59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class zad59 {

public static int iloczyn_cyfr(int x)
	{
	int wynik=1;
	 while (x>0)
	 {
	 wynik=wynik*(x%10);
	 x=x/10;
	 }
	 return wynik;
	 } 
	
public static int moc(int liczba)
	{

	 int moc=1;

	 liczba=iloczyn_cyfr(liczba); //iloczyn poczatkowy
	 while (liczba>9)
	 {
	 liczba=iloczyn_cyfr(liczba);
	 moc++;
	 }
	 return moc; 

	} 
	
	
public static boolean czynniki(int liczba) {
		
		int ile=0;
		 int czynnik=3;
		 if(liczba %2 == 0) return false;
		 while (liczba>1)
		 {
			 if (liczba % czynnik == 0) ile++;
			 while (liczba%czynnik==0)
			 {
				 liczba = liczba/czynnik;
			 }
		 czynnik=czynnik+2;
		 		if (ile>3) return false;
		 }
		 	if (ile == 3) return true;
		 	if (ile <3) return false;
			return false; 
		
	}

 public static int odwroc (int liczba){
	
			 int nowa=0;
			 while(liczba>0)
			 {
			 nowa=10*nowa+liczba%10;
			 liczba=liczba/10;
			 }
			 return nowa;
			 
	} 
	

public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
	int [] liczby= new int[1001];
	File plik = new File("liczby.txt");
	Scanner o_plik = new Scanner(new File("liczby.txt"));
	int tmp,czp=0,odwrocona,suma,pali = 0,moc1=0,moc2=0,moc3=0,moc4=0,moc5=0,moc6=0,moc7=0,moc8=0;
       int min=999999999, max=10;
	for(int i=1;i<=1000;i++) {
		
       liczby[i]=o_plik.nextInt();
        tmp=moc(liczby[i]);
        if (tmp==1)
        {
        if (liczby[i]<min) min=liczby[i];
        if (liczby[i]>max) max=liczby[i];
        }
         odwrocona = odwroc(liczby[i]);
		 suma=odwrocona+liczby[i];
		 if (odwroc(suma)==suma)pali++; 
		 
         if(czynniki(liczby[i])==true)czp++;
         
         if(moc(liczby[i])==1)moc1++;
         if(moc(liczby[i])==2)moc2++;
         if(moc(liczby[i])==3)moc3++;
         if(moc(liczby[i])==4)moc4++;
         if(moc(liczby[i])==5)moc5++;
         if(moc(liczby[i])==6)moc6++;
         if(moc(liczby[i])==7)moc7++;
         if(moc(liczby[i])==8)moc8++;
	}
	System.out.println("1.Liczby, w których rozkładzie na czynniki pierwsze występują dokładnie trzy różne czynniki z których każdy jest nieparzysty: "+czp);
	System.out.println("2.Liczby dla których suma danej liczby i liczby odwróconej jest liczbą palindromiczną: "+pali);
	System.out.println("3.");
	System.out.println("Liczby o mocy 1: "+moc1);System.out.println("Liczby o mocy 2: "+moc2);System.out.println("Liczby o mocy 3: "+moc3);System.out.println("Liczby o mocy 4: "+moc4);
	System.out.println("Liczby o mocy 5: "+moc5);System.out.println("Liczby o mocy 6: "+moc6);System.out.println("Liczby o mocy 7: "+moc7);System.out.println("Liczby o mocy 8: "+moc8);
	System.out.println("O mocy 1 liczba max: "+max+" a min: "+min);
	o_plik.close();
}

}
