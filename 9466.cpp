#include <iostream>

using namespace std;

int a[100001];
int d[100001];
int s[100001];
int n;

int dfs(int x, int cnt, int &step) {
    if (d[x] != 0) {
        if (step != s[x]) {
            return 0;
        }
        return cnt-d[x];
    }
    d[x] = cnt;
    s[x] = step;
    return dfs(a[x], cnt+1, step);
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i=1; i<=n; i++) {
            cin >> a[i];
            d[i] = 0;
            s[i] = 0;
        }

        int ans=0;
        for (int i=1; i<=n; i++) {
            if (d[i] == 0) {
                ans += dfs(i, 1, i);
            }
        }
        cout << n-ans << '\n';
    }
    return 0;
}