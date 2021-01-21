#include <iostream>
#include <algorithm>
#include <string>

#define mod 1000000LL

using namespace std;

unsigned long long dp[5001];

unsigned long long resolve(string str) {
	int n = str.length();
	dp[0] = 1;

	for(int i=1; i<=n; i++) {
		int x = str.at(i-1)-'0';
		if(x >= 1 && x <= 9) {
			dp[i] = (dp[i] + dp[i-1]) % mod;
		}
		if(i == 1) continue;
		if(str.at(i-1-1) == '0') continue;
		x = (str.at(i-1-1)-'0')*10 + (str.at(i-1)-'0');
		if(x >= 10 && x <= 26) {
			dp[i] = (dp[i] + dp[i-2]) % mod;
		}
	}

	return dp[n];
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string str;
	cin >> str;

	unsigned long long ans = resolve(str);
	cout << ans << '\n';

	return 0;
}