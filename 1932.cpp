#include <iostream>

using namespace std;

long long dp[501][501];

long long main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    long long N = 0;
    cin >> N;
    cin >> dp[1][1];

    for(long long i=2; i<=N; i++) {
    	for(long long j=1; j<=i; j++) {
    		long long tmp = 0;
    		cin >> tmp;
    		if(tmp + dp[i-1][j-1] > tmp + dp[i-1][j]) {
    			dp[i][j] = tmp + dp[i-1][j-1];
    		} else {
    			dp[i][j] = tmp + dp[i-1][j];
    		}
    	}
    }

    long long max = 0;

    for(long long i=1; i<=500; i++) {
    	if(dp[N][i] > max)
    		max = dp[N][i];
    }

    cout << max;

	return 0;
}