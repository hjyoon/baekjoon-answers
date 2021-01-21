#include <iostream>
#include <algorithm>

using namespace std;

int dp[31];

int resolve(int n) {
	if(n%2 == 1) {
		return 0;
	}
	
	dp[0] = 1;
	dp[2] = 3;
	for(int i=4; i<=n; i+=2) {
		dp[i] = 3*dp[i-2];
		for(int j=4; j<=i; j+=2) {
			dp[i] = dp[i] + 2*dp[i-j];
		}
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