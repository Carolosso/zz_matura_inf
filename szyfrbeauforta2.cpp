#include <iostream>
#include <string>
#include <Windows.h>

using namespace std;
string zmien(string tekst, string klucz) {
	string w;
	for (int i = 0; i < tekst.length(); i++) {
		int kol = (klucz[i % klucz.length()] - 65);
		int znak = (tekst[i] - 65);
		w += ((65 + (-znak + 26 + kol) % 26));
	}
	return w;
}
int main()
{
	string klucz, tekst;
	cout << "Podaj klucz: ";
	cin >> klucz;
	cin.ignore();
	cout << "Podaj tekst: ";
	getline(cin, tekst);
	string szyfrogram = zmien(tekst, klucz);
	cout << "\n\nSzyfrogram: "<< szyfrogram<<endl;
	string tekstjawny = zmien(szyfrogram, klucz);
	cout << "Tekst jawny: " << tekstjawny<<endl;
	system("pause");
	return 0;
}

// Uruchomienie programu: Ctrl + F5 lub menu Debugowanie > Uruchom bez debugowania
// Debugowanie programu: F5 lub menu Debugowanie > Rozpocznij debugowanie

// Porady dotyczące rozpoczynania pracy:
//   1. Użyj okna Eksploratora rozwiązań, aby dodać pliki i zarządzać nimi
//   2. Użyj okna programu Team Explorer, aby nawiązać połączenie z kontrolą źródła
//   3. Użyj okna Dane wyjściowe, aby sprawdzić dane wyjściowe kompilacji i inne komunikaty
//   4. Użyj okna Lista błędów, aby zobaczyć błędy
//   5. Wybierz pozycję Projekt > Dodaj nowy element, aby utworzyć nowe pliki kodu, lub wybierz pozycję Projekt > Dodaj istniejący element, aby dodać istniejące pliku kodu do projektu
//   6. Aby w przyszłości ponownie otworzyć ten projekt, przejdź do pozycji Plik > Otwórz > Projekt i wybierz plik sln
