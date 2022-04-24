#include <iostream>
#include <algorithm>

using namespace std;

int dp[10001][3];
//int dp[10001];
int a[10001];

// int resolve1(int n, int l) {
// 	if(dp[n][l] != 0 || n == 1) {
// 		return dp[n][l];
// 	}

// 	if(l == 0) {
// 		int x = resolve1(n-1, 0);
// 		int y = resolve1(n-1, 1);
// 		int z = resolve1(n-1, 2);
// 		dp[n][l] = max(x, max(y, z));
// 		return dp[n][l];
// 	} else if(l == 1) {
// 		int x = resolve1(n-1, 0);
// 		dp[n][l] = x + a[n];
// 		return dp[n][l];
// 	} else if(l == 2) {
// 		int y = resolve1(n-1, 1);
// 		dp[n][l] = y + a[n];
// 		return dp[n][l];
// 	}

// }

// int resolve1_wrapper(int n) {
// 	dp[1][0] = 0;
// 	dp[1][1] = a[1];
// 	dp[1][2] = a[1];

// 	dp[n][0] = resolve1(n, 0);
// 	dp[n][1] = resolve1(n, 1);
// 	dp[n][2] = resolve1(n, 2);

// 	ans = max(dp[n][0], max(dp[n][1], dp[n][2]));

// 	return ans;
// }

int resolve2(int n) {
	dp[1][0] = 0;
	dp[1][1] = a[1];
	dp[1][2] = a[1];

	for(int i=2; i<=n; i++) {
		dp[i][0] = max(dp[i-1][0], max(dp[i-1][1], dp[i-1][2]));
		dp[i][1] = dp[i-1][0] + a[i];
		dp[i][2] = dp[i-1][1] + a[i];
	}

	int ans = max(dp[n][0], max(dp[n][1], dp[n][2]));
	return ans;
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0;
	cin >> n;

	for(int i=1; i<=n; i++) {
		cin >> a[i];
	}

	//int res1 = resolve1_wrapper(n);
	//cout << res1;
	//cout << '\n';
	int res2 = resolve2(n);
	cout << res2;

	return 0;
}