#include <iostream>

using namespace std;

unsigned long long d[1001];

// unsigned long long solve(int n) {
// 	if(d[n] != 0) {
// 		return d[n];
// 	}

// 	if(n == 1) {
// 		d[n] = 1;
// 		return d[n];
// 	} else if(n == 2) {
// 		d[n] = 2;
// 		return d[n];
// 	} else {
// 		d[n] = solve(n-1) + solve(n-2);
// 		return d[n] % 10007;
// 	}
// }

unsigned long long solve(int n) {
	d[1] = 1;
	d[2] = 2;
	for(int i=3; i<=n; i++) {
		d[i] = (d[i-1] + d[i-2]) % 10007;
	}
	return d[n];
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	unsigned long long res = solve(n);

	cout << res;


	return 0;
}