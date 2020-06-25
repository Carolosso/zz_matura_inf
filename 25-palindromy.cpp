#include <iostream>
#include <string>
using namespace std;	
int main()
{
	string wyraz;
	int i=0, j;
	cout << "Podaj wyrazenie: ";
	getline(cin, wyraz);
	j = wyraz.length();
	while (i<j)
	{
		while (wyraz[i] == ' ')
		{
			i++;
		}
		while (wyraz[j-1] == ' ')
		{
			j--;
		}
		if (wyraz[i]!=wyraz[j-1])
		{
			cout << "NIE --> To wyrazenie nie jest palindromem!";
			return 0;
		}
		i++;
		j--;
	}
	cout << "TAK --> To wyrazenie jest palindromem!"; return 0;
}