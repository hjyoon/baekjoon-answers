#include <iostream>

using namespace std;

int min(int x, int y) {
	if(x == -1) {
		return y;
	}
	else if(y == -1) {
		return x;
	}

	if(x < y) {
		return x;
	}
	else if(y <= x) {
		return y;
	}
}

int main() {
	//freopen("ouput.txt", "w", stdout);
	int n = 0;
	cin >> n;

	int dp[5001] = {-1, -1, -1, 1, -1, 1, 2, -1, };

	for(int i=8; i<=n; i++) {
		dp[i] = 1 + min(dp[i-3], dp[i-5]);
	}

	// for(int i=3; i<=n; i++) {
	// 	cout << dp[i] << '\n';
	// }

	cout << dp[n];

	return 0;
}