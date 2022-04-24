#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Meeting {
    int begin, end;
};

bool cmp(const Meeting &u, const Meeting &v) {
    if (u.end == v.end) {
        return u.begin < v.begin;
    } else {
        return u.end < v.end;
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;
    vector<Meeting> a(n);
    for (int i=0; i<n; i++) {
        cin >> a[i].begin >> a[i].end;
    }

    sort(a.begin(), a.end(), cmp);

    for (auto x : a) {
        cout << x.begin << ' ' << x.end << '\n';
    }

    int now = 0;
    int ans =0 ;
    for (int i=0; i<a.size(); i++) {
        if (now <= a[i].begin) {
            now = a[i].end;
            ans += 1;
        }
    }

    cout << ans;
    return 0;
}