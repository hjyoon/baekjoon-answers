#include <iostream>
using namespace std;

int dp[100001];

int find_min(int a, int b) {
    if(a > b) {
        return b;
    } else {
        return a;
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int N=0, K=0;
    cin >> N >> K;

    dp[N] = 0;

    for(int i=1; i<=N; i++) {
        dp[N-i] = i;
    }

    for(int i=N+1; i<=K; i++) {
        if(i%2 == 0) {
            dp[i] = find_min(dp[i/2], dp[i-1]) + 1;
        } else {
            dp[i] = find_min(dp[i-1],  dp[(i+1)/2]+1) + 1;
        }
    }

    cout << dp[K] << '\n';

    return 0;
}