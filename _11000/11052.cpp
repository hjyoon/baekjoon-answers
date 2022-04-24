#include <iostream>
#include <algorithm>

using namespace std;

// unsigned long long solve1(int n, auto& price, auto& d) {
// 	if(d[n] != 0 || n == 0) {
// 		return d[n];
// 	}

// 	for(int i=1; i<=n; i++) {
// 		auto tmp = solve1(n-i, price, d) + price[i];
// 		d[n] = max(d[n], tmp);
// 	}

// 	return d[n];
// }

unsigned long long solve2(int n, auto& price, auto& d) {
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=i; j++) {
			auto tmp = d[i-j] + price[j];
			d[i] = max(d[i], tmp);
		}
	}
	return d[n];
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	unsigned long long d[1001] = {0, };
	int price[1001] = {0, };

	for(int i=1; i<=n; i++) {
		int tmp = 0;
		cin >> tmp;
		price[i] = tmp;
	}



	//auto res1 = solve1(n, price, d);
	//cout << res1 << '\n';
	auto res2 = solve2(n, price, d);
	cout << res2 << '\n';

	return 0;
}