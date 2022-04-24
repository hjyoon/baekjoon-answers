#include <iostream>

using namespace std;

int main() {
	int a[9] = {0};
	for(int i=0; i<9; i++) {
		cin >> a[i];
	}

	int max = 0;
	for(int i=0; i<9; i++) {
		if(a[i] > a[max]) {
			max = i;
		}
	}

	cout << a[max] << '\n' << max+1;

	return 0;
}