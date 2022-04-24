#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while(T--) {
        int n = 0;
        cin >> n;

        int res = 0;
        for(int i=1; i<=n; i+=2) {
            res += i;
        }

        cout << res << '\n';
    }

    return 0;
}