#include <bits/stdc++.h>

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

        string name, type;
        map<string, int> m;
        for(int i=0; i<n; i++) {
            cin >> name >> type;
            m[type]++;
        }

        int res = 1;
        for(auto it = m.begin(); it != m.end(); it++) {
            res *= (it->second)+1;
        }

        cout << res-1 << '\n';
    }

    return 0;
}