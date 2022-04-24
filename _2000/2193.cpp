#include <iostream>
#include <algorithm>

using namespace std;

unsigned long long solve1(int n, int l, auto& d) {
	if(d[n][l] != 0 || n == 1) {
		return d[n][l];
	}

	if(l == 0) {
		d[n][l] = solve1(n-1, 0, d) + solve1(n-1, 1, d);
		return d[n][l];
	} else if(l == 1) {
		d[n][l] = solve1(n-1, 0, d);
		return d[n][l];
	}
}

unsigned long long solve_f(int n, auto& d) {
	d[1][1] = 1;

    if (n > 1) {
        d[n][0] = solve1(n, 0, d);
        d[n][1] = solve1(n, 1, d);
	}

	unsigned long long ans = 0;
	ans = d[n][0] + d[n][1];
	return ans;
}

// unsigned long long solve2(int n, auto& d) {
//     d[1][1] = 1;
// 	for (int i=2; i<=n; i++) {
// 		d[i][0] = d[i-1][1] + d[i-1][0];
// 		d[i][1] = d[i-1][0];
//     }
	
// 	unsigned long long ans = 0;
//     ans = d[n][0] + d[n][1];
//     return ans;
// }

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	unsigned long long d[91][2] = {0, };

	auto res1 = solve_f(n, d);
	cout << res1 << '\n';
	//auto res2 = solve2(n, d);
	//cout << res2 << '\n';

	for(int i=0; i<91; i++) {
		for(int j=0; j<2; j++) {
			cout << d[i][j] << ' ';
		}
		cout << '\n';
	}

	return 0;
}