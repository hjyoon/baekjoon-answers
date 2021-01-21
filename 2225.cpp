#include <iostream>
#include <algorithm>

#define mod 1000000000LL

using namespace std;
 
//unsigned long long dp[201][201]; // dp[n][k];
unsigned long long dp[201]; // dp[n][k];

unsigned long long resolve(int n, int k) {
	// for(int i=1; i<=k; i++) {
	// 	dp[1][i] = i;
	// }

	for(int i=1; i<=k; i++) {
		dp[i] = i;
	}

	// for(int i=2; i<=n; i++) {
	// 	for(int j=1; j<=k; j++) {
	// 		for(int l=1; l<=j; l++) {
	// 			//dp[i][j] = (dp[i][j] % mod) + (dp[i-1][l] % mod);
	// 			dp[i][j] = (dp[i][j] % mod) + (dp[i-1][l] % mod);
	// 		}
	// 	}
	// }

	for(int i=2; i<=n; i++) {
		for(int j=k; j>=0; j--) {
			for(int l=1; l<=j; l++) {
				//dp[i][j] = (dp[i][j] % mod) + (dp[i-1][l] % mod);
				dp[j] = (dp[j] % mod) + (dp[j-l] % mod);
			}
		}
	}

	return (dp[k] % mod);
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	int k = 0;
	cin >> n;
	cin >> k;

	unsigned long long ans = resolve(n, k);
	cout << ans << '\n';

	return 0;
}