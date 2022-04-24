#include <bits/stdc++.h>

using namespace std;

unsigned long long fac(int n) {
    unsigned long long res = 1;
    for(int i=1; i<=n; i++) {
        res = res * i;
        res = res % 1000000007LL;
    }
    return res;
}

unsigned long long mul(unsigned long long x, unsigned long long y, unsigned long long p) {
    unsigned long long ans = 1;
    while (y > 0) {
        if (y%2 != 0) {
            ans *= x;
            ans %= p;
        }
        x *= x;
        x %= p;
        y/=2;
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0, K=0;
    cin >> N >> K;

    unsigned long long p = 1000000007LL;
    
    unsigned long long t1 = fac(N);
    unsigned long long t2 = fac(K);
    unsigned long long t3 = fac(N-K);

    unsigned long long ie = mul(t2*t3, p-2, p);

    unsigned long long res = t1 * ie;
    res = res % p;
    cout << res;

    return 0;
}