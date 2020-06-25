package zadanie58;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
public class zad58 {
	 
	public static void main(String[] args)throws FileNotFoundException ,IOException {

			String temperatura1,temperatura2,temperatura3,zegar1,zegar2,zegar3;
		    int[] temp1 = new int[1095];int[] temp2 = new int[1095];int[] temp3 = new int[1095];
		    int[] time1 = new int[1095];int[] time2 = new int[1095];int[] time3 = new int[1095];
		    
			//odczyt
			   File plik1 = new File("C:\\Users\\BULAN\\eclipse-workspace\\zadanie58\\bin\\zadanie58\\dane_systemy1.txt");
			   File plik2 = new File("C:\\Users\\BULAN\\eclipse-workspace\\zadanie58\\bin\\zadanie58\\dane_systemy2.txt");
			   File plik3 = new File("C:\\Users\\BULAN\\eclipse-workspace\\zadanie58\\bin\\zadanie58\\dane_systemy3.txt");
			   Scanner p1 = new Scanner(plik1);
			   Scanner p2 = new Scanner(plik2);
			   Scanner p3 = new Scanner(plik3);		   
			   int x=0,dni=0;
			   int r=0,skok=0,max_skok=0;
			   int max_temp1=0,max_temp2=5,max_temp3=5;
			   for(int i=1;i<=1095;i++)
			   {
				   String linia1 = p1.nextLine();  
				   String[] dzielona1 = linia1.split("\\s+");temperatura1=dzielona1[1];zegar1=dzielona1[0];
				   temp1[i-1]=Integer.parseInt(temperatura1,2);
				   time1[i-1]=Integer.parseInt(zegar1,2);
				   	int j=i;
				   		if(j<1095) {
				   			r=((temp1[i-1])-(temp1[j])*(temp1[i-1])-(temp1[j]));
				   			skok=r/(j-i+1);
				   			if(skok > max_skok) {
				   				max_skok=skok;
				   			}    
				   		j++;
				   		}
				   		
				   String linia2 = p2.nextLine();  
				   String[] dzielona2 = linia2.split("\\s+");temperatura2=dzielona2[1];zegar2=dzielona2[0];
				   temp2[i-1]=Integer.parseInt(temperatura2,4);
				   time2[i-1]=Integer.parseInt(zegar2,4);
				   
				   String linia3 = p3.nextLine();  
				   String[] dzielona3 = linia3.split("\\s+");temperatura3=dzielona3[1];zegar3=dzielona3[0];
				   temp3[i-1]=Integer.parseInt(temperatura3,8);
				   time3[i-1]=Integer.parseInt(zegar3,8);
				   
				   boolean rekord=false;
				   if(temp1[i-1] > max_temp1) {
					   max_temp1=temp1[i-1];
					   rekord=true;
				   }
				   if(temp2[i-1] > max_temp2) {
					   max_temp2=temp2[i-1];
					   rekord=true;
				   }
				   if(temp3[i-1] > max_temp3) {
					   max_temp3=temp3[i-1];
					   rekord=true;
				   }
				   if(rekord==true) {
					   dni+=1;
				   }
				   	 
				   int czas=12;
				   if(time1[i-1]%24!=czas&&time2[i-1]%24!=czas&&time3[i-1]%24!=czas) {
					   x++;
				   }
				   czas+=24;
			   }

			   /*1*/System.out.println("Zadanie 1.");
			    Arrays.sort(temp1);
		        System.out.println("Najnizsza temperatura z S1: "+Integer.toString(temp1[0],2)+"°C");
		        Arrays.sort(temp2);
		        System.out.println("Najnizsza temperatura z S2: "+Integer.toString(temp2[0],2)+"°C");
		        Arrays.sort(temp3);
		        System.out.println("Najnizsza temperatura z S3: "+Integer.toString(temp3[0],2)+"°C");    
		        /*2*/System.out.println("Zadanie 2.");      
		        System.out.println("Liczba blednych pomiarow: "+x);
		        /*3*/System.out.println("Zadanie 3.");
		        System.out.println("Liczba rekordowych dni: "+dni);
		        /*4*/System.out.println("Zadanie 4.");
		        System.out.println("Najwiekszy skok temperatury w S1: "+max_skok);
		        
		        //zapis do pliku
		        PrintWriter zapis = new PrintWriter("wyniki_systemy.txt");
		        /*1*/zapis.println("Zadanie 1.");
		        zapis.println("Najnizsza temperatura z S1: "+Integer.toString(temp1[0],2)+"°C");
		        zapis.println("Najnizsza temperatura z S2: "+Integer.toString(temp2[0],2)+"°C");
		        zapis.println("Najnizsza temperatura z S3: "+Integer.toString(temp3[0],2)+"°C");    
		        /*2*/zapis.println("Zadanie 2.");      
		        zapis.println("Liczba blednych pomiarow: "+x);
		        /*3*/zapis.println("Zadanie 3.");
		        zapis.println("Liczba rekordowych dni: "+dni);
		        /*4*/zapis.println("Zadanie 4.");
		        zapis.println("Najwiekszy skok temperatury w S1: "+max_skok);
		        zapis.close();
			    p1.close();p2.close();p3.close();	
	}
}
