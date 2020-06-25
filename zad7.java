package zad7;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class zad7 {
	
	public static void main(String[] args) throws IOException {
		
			int[] T = new int[64];int[] A = new int[64];int[] B = new int[64];
			Scanner scan = new Scanner(System.in);
	        System.out.print("Podaj m: ");
	        int m = scan.nextInt();
	        int n = (int) Math.pow(2, m);
		      if(n==1) {
		    	  T[0]=1;
		    	  T[1]=n;
		        System.out.print("T["+T[0]+";");
		        System.out.print(T[1]+"]");
		        	}	
		        else {
		        	int k=n/2;
		      		for(int i=0;i<=k;i++){
		      			T[i]=i+1;		
		      		}
		      		Arrays.sort(T); 
		      		for(int i=0;i<=k;i++) {
		      			A[i]=T[i];  
		      			System.out.print("A["+A[i]+"]");
		      		}
		        }
		        
		        	
	        	
	        	
	        }
	}
