#include <iostream>

using namespace std;

// unsigned long long solve(int n, auto& d) {
// 	if(d[n] != 0) {
// 		return d[n];
// 	}

// 	if(n == 1) {
// 		d[n] = 1;
// 		return d[n];
// 	} else if(n == 2) {
// 		d[n] = 2;
// 		return d[n];
// 	} else if(n == 3) {
// 		d[n] = 4;
// 		return d[n];
// 	} else {
// 		d[n] = solve(n-1, d) + solve(n-2, d) + solve(n-3, d);
// 		return d[n];
// 	}
// }

unsigned long long solve(int n, auto& d) {
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for(int i=4; i<=n; i++) {
		d[i] = d[i-1] + d[i-2] + d[i-3];
	}
	return d[n];
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int T = 0;
	cin >> T;

	while(T--) {
		int n = 0;
		unsigned long long d[11] = {0, };
		cin >> n;
		unsigned long long res = solve(n, d);
		cout << res << '\n';
	}


	return 0;
}