#include <iostream>
#include <algorithm>

using namespace std;

bool check[1001];
int dp[1001];
int a[1001];

int resolve1(int n) {
	if(check[n] == true || n == 1) {
		return dp[n];
	}

	for(int j=n-1; j>=1; j--) {
		int tmp = resolve1(j);
		if(tmp + 1 >= dp[n] && a[j] < a[n]) {
			dp[n] = 1 + tmp;
		}
	}

	check[n] = true;
	return dp[n];

}

int resolve1_wrapper(int n) {
	for(int i=1; i<=n; i++) {
		dp[i] = 1;
	}

	dp[n] = resolve1(n);

	int ans = 0;

	for(int i=1; i<=n; i++) {
		if(ans < dp[i]) {
			ans = dp[i];
		}
	}

	return ans;
}

// int resolve2(int n) {
// 	for(int i=1; i<=n; i++) {
// 		dp[i] = 1;
// 	}

// 	for(int i=2; i<=n; i++) {
// 		for(int j=1; j<i; j++) {
// 			if(dp[j] + 1 >= dp[i] && a[j] < a[i]) {
// 				dp[i] = 1 + dp[j];
// 			}
// 		}
// 	}

// 	int ans = 0;

// 	for(int i=1; i<=n; i++) {
// 		if(ans < dp[i]) {
// 			ans = dp[i];
// 		}
// 	}

// 	return ans;
// }

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0;
	cin >> n;

	for(int i=1; i<=n; i++) {
		cin >> a[i];
	}

	int res1 = resolve1_wrapper(n);
	cout << res1;
	//cout << '\n';
	//int res2 = resolve2(n);
	//cout << res2;

	return 0;
}