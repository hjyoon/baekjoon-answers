#include <iostream>

using namespace std;

unsigned long long dp[101];

unsigned long long resolve(int n) {
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 2;
	dp[6] = 3;
	dp[7] = 4;
	dp[8] = 5;
	for(int i=9; i<=n; i++) {
		dp[i] = dp[i-1] + dp[i-5];
	}

	return dp[n];
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	while(n--) {
		int tmp;
		cin >> tmp;
		unsigned long long ans = resolve(tmp);
		cout << ans << '\n';
	}

	return 0;
}