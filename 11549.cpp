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

    int T = 0;
    cin >> T;
    cin.get();

    vector<int> v;
    for(int i=0; i<5; i++) {
        int tmp = 0;
        cin >> tmp;
        v.push_back(tmp);
    }

    int res = 0;
    for(int i=0; i<5; i++) {
        if(v[i] == T) {
            res++;
        }
    }

    cout << res;

    return 0;
}