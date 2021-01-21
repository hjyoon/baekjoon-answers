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

    vector<int> v;

    for(int i=0; i<3; i++) {
        int tmp = 0;
        cin >> tmp;
        v.push_back(tmp);
    }

    sort(v.begin(), v.end());

    for(auto it = v.begin(); it!=v.end(); ++it) {
        cout << *it << ' ';
    }

    return 0;
}