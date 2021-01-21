#include <iostream>
#include <algorithm>

using namespace std;

// unsigned long long solve1(int n, auto& d, int l, auto& a) {
// 	if(d[n][l] != 0 || n == 1) {
// 		return d[n][l];
// 	}

// 	if(l == 0) {
// 		unsigned long long x = solve1(n-1, d, 0, a);
// 		unsigned long long y = solve1(n-1, d, 1, a);
// 		unsigned long long z = solve1(n-1, d, 2, a);
// 		d[n][0] = max(x, max(y, z));
// 		return d[n][l];
// 	} else if(l == 1) {
// 		unsigned long long x = solve1(n-1, d, 0, a);
// 		unsigned long long z = solve1(n-1, d, 2, a);
// 		d[n][1] = max(x, z) + a[n][1];
// 		return d[n][l];
// 	} else if(l == 2) {
// 		unsigned long long x = solve1(n-1, d, 0, a);
// 		unsigned long long y = solve1(n-1, d, 1, a);
// 		d[n][2] = max(x, y) + a[n][2];
// 		return d[n][l];
// 	}

// 	return d[n][l];
// }

// unsigned long long solve_f(int n, auto& d, auto& a) {
// 	d[1][0] = 0;
// 	d[1][1] = a[1][1];
// 	d[1][2] = a[1][2];

// 	if (n > 1) {
// 		d[n][0] = solve1(n, d, 0, a);
// 		d[n][1] = solve1(n, d, 1, a);
// 		d[n][2] = solve1(n, d, 2, a);
// 	}

// 	unsigned long long ans = 0;
// 	ans = max(d[n][0], max(d[n][1], d[n][2]));
// 	return ans;
// }

unsigned long long solve2(int n, auto& d, auto& a) {
 	d[1][0] = 0;
 	d[1][1] = a[1][1];
 	d[1][2] = a[1][2];

	for(int i=2; i<=n; i++) {
		d[i][0] = max(d[i-1][0], max(d[i-1][1], d[i-1][2]));
		d[i][1] = max(d[i-1][0], d[i-1][2]) + a[i][1];
		d[i][2] = max(d[i-1][0], d[i-1][1]) + a[i][2];
	}

	unsigned long long ans = 0;
	ans = max(d[n][0], max(d[n][1], d[n][2]));
	return ans;
}



int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int T = 0;
	cin >> T;

	while(T--) {
		int n = 0;
		cin >> n;


		int** a = new int*[n+1]();
		for(int i=0; i<n+1; i++) {
			a[i] = new int[3]();
		}

		for(int i=1; i<=n; i++) {
			cin >> a[i][1];
		}
		for(int i=1; i<=n; i++) {
			cin >> a[i][2];
		}

		int** d = new int*[n+1]();
		for(int i=0; i<n+1; i++) {
			d[i] = new int[3]();
		}

		//unsigned long long res = solve_f(n, d, a);
		//cout << res << '\n';
		unsigned long long res = solve2(n, d, a);
		cout << res << '\n';

		for(int i=0; i<n+1; i++) {
			delete[] a[i];
		}
		delete[] a;

		for(int i=0; i<n+1; i++) {
			delete[] d[i];
		}
		delete[] d;
	}

	return 0;
}