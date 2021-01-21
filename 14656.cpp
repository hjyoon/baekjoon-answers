#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	int n=0;
	int cnt=0;

	cin >> n;
	int* num = new int[n];

	for(int i=0; i<n; i++) {
		cin >> num[i];
	}

	for(int i=0; i<n; i++) {
		if(num[i] != i+1) cnt++;
	}

	cout << cnt;

	delete [] num;
}