#include <iostream>
#include <algorithm>

using namespace std;

int dp[31][4];

int resolve(int n) {
	dp[1][1] = 1;
	dp[1][2] = 1;
	dp[1][3] = 1;
	for(int i=3; i<=n; i++) {

	}

	int ans = dp[n];
	return ans;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0;
	cin >> n;

	cout << resolve(n);

	return 0;
}