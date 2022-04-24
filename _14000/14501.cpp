#include <iostream>

using namespace std;

int N;
int a[17];
int dp[16][2];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> dp[i][0] >> dp[i][1];
    }

    for(int i=N; i>=1; i--) {
        if(dp[i][0] + i <= N + 1) {
            if(dp[i][1] + a[i+dp[i][0]] <= a[i+1]) {
                a[i] = a[i+1];
            }
            else {
                a[i] = dp[i][1] + a[i+dp[i][0]];
            }
        }
        else {
            a[i] = a[i+1];
        }
    }

    // for(int i=1; i<=N; i++) {
    //     cout << a[i] << ' ';
    // }

    cout << a[1];


    return 0;
}