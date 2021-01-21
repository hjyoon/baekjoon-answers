#include <iostream>
#include <algorithm>

using namespace std;

int dp[301][3];
int a[301];

void resolve(int n) {
	dp[1][1] = a[1];
	for(int i=2; i<=n; i++) {
		dp[i][1] = max(dp[i-2][1], dp[i-2][2]) + a[i];
		dp[i][2] = dp[i-1][1] + a[i];
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0;
	cin >> n;

	for(int i=1; i<=n; i++) {
		cin >> a[i];
	}

	resolve(n);

	int ans = max(dp[n][1], dp[n][2]);

	cout << ans;

	return 0;
}