#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    vector<int> v;
    int sum = 0;

    for(int i=0; i<9; i++) {
        int tmp = 0;
        cin >> tmp;
        v.push_back(tmp);
        sum += tmp;
    }

    int i=0, j=0;
    bool s = false;
    for(i=0; i<8; i++) {
        for(j=i+1; j<9; j++) {
            if(sum - (v[i] + v[j]) == 100) {
                s = true;
                break;
            }
            if(s) {
                break;
            }
        }
        if(s) {
            break;
        }
    }

    v.erase(v.begin()+j);
    v.erase(v.begin()+i);

    sort(v.begin(), v.end());

    for(auto t : v) {
        cout << t << '\n';
    }
    
    return 0;
}