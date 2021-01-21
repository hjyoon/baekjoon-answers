#include <iostream>
#include <algorithm>

using namespace std;

bool check[1001];
int dp[1001];
int dp2[1001];
int a[1001];

void resolve2_1(int n) {
	for(int i=1; i<=n; i++) {
		dp[i] = 1;
		for(int j=1; j<i; j++) {
			if(dp[j] + 1 >= dp[i] && a[j] < a[i]) {
				dp[i] = 1 + dp[j];
			}
		}
	}
}

void resolve2_2(int n) {
	for(int i=n; i>=1; i--) {
		dp2[i] = 1;
		for(int j=1; j<=n; j++) {
			if(dp2[j] + 1 >= dp2[i] && a[j] < a[i]) {
				dp2[i] = 1 + dp2[j];
			}
		}
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

	resolve2_1(n);
	resolve2_2(n);

	int ans = 0;
    for (int i=1; i<=n; i++) {
        if (ans < dp[i]+dp2[i]-1) {
            ans = dp[i]+dp2[i]-1;
        }
    }

	cout << ans;

	return 0;
}
