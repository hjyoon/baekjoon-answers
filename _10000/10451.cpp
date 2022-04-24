#include <iostream>

using namespace std;

int a[1001];
bool c[1001];

void dfs(int x) {
    if (c[x] == true) {
        return;
    } else {
        c[x] = true;
        dfs(a[x]);
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        for(int i=1; i<=n; i++) {
            cin >> a[i];
            c[i] = false;
        }

        int ans = 0;
        for (int i=1; i<=n; i++) {
            if(c[i] == false) {
                dfs(i);
                ans++;
            }
        }
        cout << ans << '\n';
    }

    return 0;
}