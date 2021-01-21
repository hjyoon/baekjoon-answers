#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    unsigned long long A=0, B=0, C=0;

    cin >> A >> B >> C;

    unsigned long long res = 1;
    unsigned long long mul = A;

    mul = mul % C;
    while(B > 0) {
        if(B%2 == 1) {
            res = res * mul;
            res = res % C;
        }
        mul = mul * mul;
        mul = mul % C;
        B = B/2;
    }

    cout << res;

    return 0;
}