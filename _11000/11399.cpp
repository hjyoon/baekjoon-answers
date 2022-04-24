#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;
    vector<int> a;
    
    for (int i=0; i<n; i++) {
        int tmp;
        cin >> tmp;
        a.push_back(tmp);
    }

    sort(a.begin(), a.end());

    int ans = 0;

    for (auto x : a) {
        ans = ans + (x*n);
        n--;
    }

    cout << ans;

    return 0;
}