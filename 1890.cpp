#include <iostream>

using namespace std;

int N;
int a[101][101];
long long dp[101][101];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    cin >> N;
    for (int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            cin >> a[i][j];
        }
    }

    dp[1][1+a[1][1]] = 1;
    dp[1+a[1][1]][1] = 1;
    for (int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            if(i == N && j == N) {
                break;
            }

            if(dp[i][j] > 0) {
                int jump = a[i][j];
                if(i+jump <= N) {
                    dp[i+jump][j] = dp[i+jump][j] + dp[i][j];
                }
                if(j+jump <= N) {
                    dp[i][j+jump] = dp[i][j+jump] + dp[i][j];
                }
            }
        }
    }
    
    // for (int i = 1; i <= N; i++) {
    //     for(int j = 1; j <= N; j++) {
    //         cout << dp[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }


    cout << dp[N][N];

    return 0;
}