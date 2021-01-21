#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int a[7] = {0, };
	for(int i=0; i<7; i++) {
		cin >> a[i];
	}

	int min = 100;
	int sum = 0;
	for(int i=0; i<7; i++) {
		if(a[i] % 2 == 1) {
			if(a[i] < min) {
				min = a[i];
			}
			sum += a[i];
		}
	}

	if(sum != 0) {
		cout << sum << '\n' << min;
	}
	else {
		cout << -1;
	}

	return 0;
}