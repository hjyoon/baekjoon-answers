#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <deque>
#include <algorithm>

using namespace std;

unsigned long long fac(int n) {
    unsigned long long res = 1;
    for(int i=1; i<=n; i++) {
        res = res * i;
        res = res % 1000000007LL;
    }
    //cout << res << '\n';
    return res;
}

unsigned long long cal(unsigned long long x, int m) {
    unsigned long long res = 0;
    for (int i=1; i<m; i++) {
        if ((x*i) % m == 1) {
            res = i;
        }
    }
    res = res % m;
    return res;
}


int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int p = 1000000007LL;
    int N=0, K=0;
    cin >> N >> K;

    unsigned long long t1 = fac(N);
    unsigned long long t2 = fac(K);
    unsigned long long t3 = fac(N-K);

    unsigned long long ie = cal(t2*t3, p);

    unsigned long long res = t1 * ie;
    res = res % p;
    cout << res;

    return 0;
}