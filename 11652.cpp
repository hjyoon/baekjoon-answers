#include <iostream>
#include <map>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    map<long long, int> m;

    int n;
    cin >> n;

    for(int i=0; i<n; i++) {
        long long tmp;
        cin >> tmp;
        m[tmp]++;
    }

    long long ans = 0;
    int num = 0;
    
    for(auto &x : m) {
        long long key = x.first;
        int cnt = x.second;
        if(cnt > num) {
            num = cnt;
            ans = key;
        }
    }

    cout << ans;

    return 0;
}