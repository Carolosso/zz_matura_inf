package zad86;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class zad86 {

	private static void zad3() throws FileNotFoundException {
		Scanner s1 = new Scanner(new File("dane_wybory.txt"));
		int mk1m = 0;
		int mk2m = 0;
		int mk3m = 0;
		int mk4m = 0;
		int mk5m = 0;
		// dla kazdego okregu/lini
		while (s1.hasNextLine()) {
			// pobieramy linie
			String linia = s1.nextLine();
			// dzielimy po spacji
			String[] split = linia.split(" ");
			// okreg to pierwszy element
			String okreg = split[0];
			// zapisujemy liczbe glosow
			int gk1 = Integer.parseInt(split[1]);
			int gk2 = Integer.parseInt(split[2]);
			int gk3 = Integer.parseInt(split[3]);
			int gk4 = Integer.parseInt(split[4]);
			int gk5 = Integer.parseInt(split[5]);
			// liczba mandatow
			int mk1 = 0;
			int mk2 = 0;
			int mk3 = 0;
			int mk4 = 0;
			int mk5 = 0;
			// dla 20 mandatow
			for (int i = 0; i < 20; i++) {
				// tworzymy liste
				ArrayList<Integer> wk = new ArrayList<Integer>();
				// dodajemy wyniki wspolczynnika
				int wk1 = gk1 / (2 * mk1 + 1);
				wk.add(wk1);
				int wk2 = gk2 / (2 * mk2 + 1);
				wk.add(wk2);
				int wk3 = gk3 / (2 * mk3 + 1);
				wk.add(wk3);
				int wk4 = gk4 / (2 * mk4 + 1);
				wk.add(wk4);
				int wk5 = gk5 / (2 * mk5 + 1);
				wk.add(wk5);
				// wybieramy najwyzsza wartosc i sprawdzamy ktory to komitet i dodajemy mandat
				if (Collections.max(wk) == wk1)
					mk1++;
				else if (Collections.max(wk) == wk2)
					mk2++;
				else if (Collections.max(wk) == wk3)
					mk3++;
				else if (Collections.max(wk) == wk4)
					mk4++;
				else if (Collections.max(wk) == wk5)
					mk5++;
			}
			// wyznaczanie najwiekszej liczby mandatow
			if (mk1 > mk1m)
				mk1m = mk1;
			if (mk2 > mk2m)
				mk2m = mk2;
			if (mk3 > mk3m)
				mk3m = mk3;
			if (mk4 > mk4m)
				mk4m = mk4;
			if (mk5 > mk5m)
				mk5m = mk5;
		}
		System.out.println("K1: " + mk1m);
		System.out.println("K2: " + mk2m);
		System.out.println("K3: " + mk3m);
		System.out.println("K4: " + mk4m);
		System.out.println("K5: " + mk5m);
	}

	private static void zad4() throws FileNotFoundException {
		Scanner s2 = new Scanner(new File("dane_wybory.txt"));
		int mk1m = 0;
		int mk2m = 0;
		int mk3m = 0;
		int mk4m = 0;
		int mk5m = 0;
		int k1 = 0;
		int k2 = 0;
		int k3 = 0;
		int k4 = 0;
		int k5 = 0;
		// dla kazdego okregu/lini
		while (s2.hasNextLine()) {
			// pobieramy linie
			String linia = s2.nextLine();
			// dzielimy po spacji
			String[] split = linia.split(" ");
			// okreg to pierwszy element
			String okreg = split[0];
			// zapisujemy liczbe glosow
			int gk1 = Integer.parseInt(split[1]);
			int gk2 = Integer.parseInt(split[2]);
			int gk3 = Integer.parseInt(split[3]);
			int gk4 = Integer.parseInt(split[4]);
			int gk5 = Integer.parseInt(split[5]);
			// liczba mandatow
			int mk1 = 0;
			int mk2 = 0;
			int mk3 = 0;
			int mk4 = 0;
			int mk5 = 0;
			// dla 20 mandatow
			for (int i = 0; i < 20; i++) {
				// tworzymy liste
				ArrayList<Double> wk = new ArrayList<Double>();
				// dodajemy wyniki wspolczynnika
				double wk1 = gk1 / (2 * mk1 + 1);
				wk.add((double) wk1);
				double wk2 = gk2 / (2 * mk2 + 1);
				wk.add((double) wk2);
				double wk3 = gk3 / (2 * mk3 + 1);
				wk.add((double) wk3);
				double wk4 = gk4 / (2 * mk4 + 1);
				wk.add((double) wk4);
				double wk5 = gk5 / (2 * mk5 + 1);
				wk.add((double) wk5);
				// wybieramy najwyzsza wartosc i sprawdzamy ktory to komitet i dodajemy mandat
				if (Collections.max(wk) == wk1)
					mk1++;
				else if (Collections.max(wk) == wk2)
					mk2++;
				else if (Collections.max(wk) == wk3)
					mk3++;
				else if (Collections.max(wk) == wk4)
					mk4++;
				else if (Collections.max(wk) == wk5)
					mk5++;
			}
			k1 += mk1;
			k2 += mk2;
			k3 += mk3;
			k4 += mk4;
			k5 += mk5;
		}
		System.out.println("K1: " + k1);
		System.out.println("K2: " + k2);
		System.out.println("K3: " + k3);
		System.out.println("K4: " + k4);
		System.out.println("K5: " + k5);
	}

	public static void zad5() {
		int[] testin = new int[2];
		int[] testout = new int[2];
		int glosow = 100000, mandatow = 20;
		int[] lmandatow = { 20, 40, 100 };
		for (int j = 0; j < 3; j++) {
			mandatow = lmandatow[j];
			for (int i = 1; i <= glosow / 2; i++) {
				testin[0] = i;
				testin[1] = glosow - i;
				///
				int indmax = 0;
				double[] x = new double[20];
				for (int z = 0; z < 2; z++) {
					testout[z] = 0;
					x[z] = (double) testin[z];
				}
				for (int c = 0; c < mandatow; c++) {
					indmax = 0;
					for (int v = 1; v < 2; v++) {
						if (x[v] > x[indmax])
							indmax = v;
						testout[indmax]++;
						x[indmax] = testin[indmax] / (2.0 * testout[indmax] + 1);
					}
					///

				}
				if (testout[0] == testout[1]) {
					System.out.println("Dla m=" + mandatow / 2 + ": " + i);
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Zad 3.");
		zad3();
		System.out.println("");
		System.out.println("Zad 4.");
		zad4();
		System.out.println("");
		System.out.println("Zad 5.");
		zad5();
	}

}
