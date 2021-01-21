#include <iostream>
#include <vector>

using namespace std;

long long f[21] = {1};
bool c[21];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    for (int i=1; i<=20; i++) {
        f[i] = f[i-1] * i;
    }

    int n = 0;
    cin >> n;

    int what = 0;
    cin >> what;

    if (what == 2) {    // 순열을 나타내는 임의의 수 N의 K번째 구하기
        vector<int> a(n);
        for (int i=0; i<n; i++) {
            cin >> a[i];
        }
        long long ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=1; j<a[i]; j++) {
                if (c[j] == false) {
                    ans += f[n-i-1];
                }
            }
            c[a[i]] = true;
        }
        cout << ans+1 << '\n';
    } else if (what == 1) {     // K번째 수열 구하기
        long long k;
        cin >> k;
        vector<int> a(n);
        for (int i=0; i<n; i++) {
            for (int j=1; j<=n; j++) {
                if (c[j] == true) continue;
                if (f[n-i-1] < k) {
                    k -= f[n-i-1];
                } else {
                    a[i] = j;
                    c[j] = true;
                    break;
                }
            }
        }
        for (int i=0; i<n; i++) {
            cout << a[i] << ' ';
        }
        cout << '\n';
    }
    return 0;
}