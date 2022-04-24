#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int dp[30][30];

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while(T--) {
        int N = 0, M = 0;
        cin >> N >> M;

        for(int i=1; i<=29; i++) {
            dp[i][i] = 1;
        }

        for(int i=1; i<=29; i++) {
            dp[1][i] = i;
        }

        for(int i=2; i<=N; i++) {
            for(int j=i+1; j<=M; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }

        cout << dp[N][M] << '\n';
    }

	return 0;
}