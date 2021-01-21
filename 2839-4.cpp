#include <iostream>

using namespace std;

int main() {
	//freopen("ouput.txt", "w", stdout);
	int n = 0;
	cin >> n;

	int min = 99999;

	for(int i=0; i<=n/3; i++) {
		for(int j=0; j<=n/5; j++) {
			if(3*i + 5*j == n) {
				if(i+j < min) {
					min = i+j;
				}
			}
		}
	}

	if(min == 99999) {
		cout << -1;
	}
	else {
		cout << min;
	}
	
	return 0;
}