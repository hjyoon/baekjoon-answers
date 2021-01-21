#include <iostream>
#include <stdio.h>

using namespace std;

int ct = 1;
int dp[105][50];
bool vac[105];

int main() {
    freopen("../input.txt", "r", stdin);

    int n = 0, m = 0;
    cin >> n >> m;

    for(int i=1; i<=n; i++) {
        vac[i] = true;
    }

    for(int i=0; i<m; i++) {
        int k = 0;
        cin >> k;
        vac[k] = false;
        if(ct == k) {
            ct++;
        }
    }

    ct--;
    n -= ct;

    //printf("ct = %d\n", ct);
    //printf("n = %d\n", n);

    if(ct != 0) {
        for(int i=1; i<=n; i++) {
            vac[i] = vac[i+ct];
        }
    }

    int ma = (n/5)*2+5;

    dp[1][0] = 10;

    for(int i=2; i<=n; i++) {
        if(vac[i] == false) {   // 쉬는날이면
            for(int j=0; j<ma; j++) {
                dp[i][j] = dp[i-1][j];
            }
        }

        if(i-1 > 0) {
            for(int j=0; j<ma; j++) {
                if(dp[i-1][j] != 0) {
                    if(dp[i][j] == 0) {
                        dp[i][j] = dp[i-1][j] + 10;
                    }
                    else {
                        dp[i][j] = min(dp[i-1][j] + 10, dp[i][j]);
                    }
                }
                if(j+3 < ma && dp[i-1][j+3] != 0) {
                    dp[i][j] = min(dp[i][j], dp[i-1][j+3]);
                }
            }
        }
        if(i == 3) {
            if(dp[i][1] == 0) {
                dp[i][1] = 25;
            }
            else {
                dp[i][1] = min(25, dp[i][1]);
            }
        }
        if(i-3 > 0) {
            for(int j=1; j<ma; j++) {
                if(dp[i-3][j-1] != 0) {
                    if(dp[i][j] == 0) {
                        dp[i][j] = dp[i-3][j-1]+25;
                    }
                    else {
                        dp[i][j] = min(dp[i-3][j-1] + 25, dp[i][j]);
                    }
                }
            }
        }
        if(i == 5) {
            if(dp[i][2] == 0) {
                dp[i][2] = 37;
            }
            else {
                dp[i][2] = min(37, dp[i][2]);
            }
        }
        if(i-5 > 0) {
            for(int j=2; j<ma; j++) {
                if(dp[i-5][j-2] != 0) {
                    if(dp[i][j] == 0) {
                        dp[i][j] = dp[i-5][j-2] + 37;
                    }
                    else {
                        dp[i][j] = min(dp[i-5][j-2] + 37, dp[i][j]);
                    }
                }
            }
        }
    }

    long long Min = (long long)dp[n][0];

    for(int i=1; i<ma; i++) {
        if(dp[n][i] != 0 && Min > dp[n][i]) {
            Min = (long long)dp[n][i];
        }
    }

    for(int i=0; i<n+1; i++) {
        printf("%2d\t", i);
        for(int j=0; j<ma; j++) {
            printf("%3d ", dp[i][j]);
        }
        printf("\n");
    }
    
    cout << Min*1000 << '\n';

}