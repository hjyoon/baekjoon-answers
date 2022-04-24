#include <iostream>

using namespace std;

unsigned long long mod = 10007;

// unsigned long long solve1(int n, int l, auto& d) {
// 	if(d[n][l] != 0 || n == 1) {
// 		return d[n][l];
// 	}

// 	for(int i=0; i<=l; i++) {
// 		d[n][l] = (d[n][l] + solve1(n-1, i, d)) % mod;
// 	}
// 	return d[n][l] % mod;
// }

// unsigned long long solve_f(int n, auto& d) {
// 	for(int i=0; i<=9; i++) {
// 		d[1][i] = 1;
// 	}

//     if (n > 1) {
//     	for(int i=0; i<=9; i++) {
// 	        d[n][i] = solve1(n, i, d) % mod;
// 	    }
// 	}

// 	unsigned long long ans = 0;
// 	for(int i=0; i<=9; i++) {
// 		ans = (ans + d[n][i]) % mod;
// 	}

// 	return ans;
// }

unsigned long long solve2(int n, auto& d) {
	for(int i=0; i<=9; i++) {
		d[1][i] = 1;
	}
	for(int i=2; i<=n; i++) {
		d[i][0] = d[i-1][0];
		for(int j=1; j<=9; j++) {
			for(int k=0; k<=j; k++) {
				d[i][j] = (d[i][j] + d[i-1][k]) % mod;
			}
		}
	}

	unsigned long long ans = 0;
	for(int i=0; i<=9; i++) {
		ans = (ans + d[n][i]) % mod;
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0;
	cin >> n;

	unsigned long long d[1001][10] = {0, };

	//auto res1 = solve_f(n, d);
	//cout << res1;

	

	auto res2 = solve2(n, d);

	for(int i=1; i<=1000; i++) {
		for(int j=0; j<=9; j++) {
			cout << d[i][j] << ' ';
		}
		cout << '\n';
	}

	cout << res2;



	return 0;
}