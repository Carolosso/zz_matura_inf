package zad30;

import java.util.Arrays;
import java.util.Scanner;

public class zad30 {

	public static char deszyfruj(char znak,int k) {
		k=k%26;
		int kod=(int)znak-k;
		if(kod>90)kod=kod-26;
		return (char)kod;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1=new Scanner(System.in);
		String text=s1.nextLine(); 
		char[]znaki=text.toCharArray();
		char[] wynik = new char[znaki.length];
		for(int i=0;i<znaki.length;i++) {
			wynik[i]=deszyfruj(znaki[i],i+1);
		}
		System.out.println(Arrays.toString(wynik));
	}

}
