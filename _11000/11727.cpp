#include <iostream>

using namespace std;

unsigned long long d[1001];

unsigned long long solve1(int n) {
	if(d[n] != 0) {
		return d[n];
	}

	if(n == 1) {
		d[n] = 1;
		return d[n];
	} else if(n == 2) {
		d[n] = 3;
		return d[n];
	} else {
		d[n] = (solve1(n-1) + solve1(n-2)*2) % 10007;
		return d[n];
	}
}

unsigned long long solve2(int n) {
	d[1] = 1;
	d[2] = 3;
	for(int i=3; i<=n; i++) {
		d[i] = (d[i-1] + d[i-2]*2) % 10007;
	}
	return d[n];
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	unsigned long long res1 = solve1(n);
	unsigned long long res2 = solve2(n);

	cout << res1;
	cout << '\n';
	cout << res2;

	return 0;
}