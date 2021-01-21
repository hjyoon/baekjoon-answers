#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;

    vector<pair<int,int>> a(n);

    for (int i=0; i<n; i++) {
        cin >> a[i].first;
        a[i].second = i; // original
    }

    sort(a.begin(),a.end());

    int ans = 0;
    for (int i=0; i<n; i++) {
        if (ans < a[i].second - i) {
            ans = a[i].second - i;
        }
    }

    cout << ans+1;

    return 0;
}