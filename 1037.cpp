#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0;

    cin >> N;

    vector<int> v;

    for(int i=0; i<N; i++) {
        int tmp = 0;
        cin >> tmp;
        v.push_back(tmp);
    }

    sort(v.begin(), v.end(), greater<int>());

    int res = v.front();
    if(res % 2 == 0) {
        res *= 2;
    } else {
        res *= v.back();
    }

    cout << res;

    return 0;
}