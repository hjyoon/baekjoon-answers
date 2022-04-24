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
        res = res % 10007;
    }
    //cout << res << '\n';
    return res;
}

unsigned long long cal(int x, int m) {
    int res = 0;
    for (int i=1; i<m; i++) {
        if ((x*i) % m == 1) {
            res = i;
        }
    }
}


int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    //int p = 
    int N=0, K=0;
    cin >> N >> K;

    unsigned long long t1 = fac(N);
    unsigned long long t2 = fac(K);
    unsigned long long t3 = fac(N-K);

    //unsigned long long ie = cal(t2*t3, p);    

    unsigned long long res = t1 / (t2 * t3);
    cout << res;

    
    return 0;
}