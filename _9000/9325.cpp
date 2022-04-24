#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T=0;

    cin >> T;

    while(T--) {
        int s = 0;
        int n = 0;
        int q = 0;
        int p = 0;

        int res = 0;

        cin >> s;
        cin >> n;

        res = res + s;

        for(int i=0; i<n; i++) {
            int q = 0;
            int p = 0;
            cin >> q;
            cin >> p;

            res += q * p;
        }

        cout << res << '\n';
    }

    return 0;
}