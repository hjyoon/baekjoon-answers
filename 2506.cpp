#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    freopen("input.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = 0;
    cin >> n;

    int res = 0;
    int p = 0;
    for(int i=0; i<n; i++) {
        int tmp = 0;
        cin >> tmp;
        if(tmp == 1) {
            p++;
        }
        else {
            p = 0;
        }
        res += p;
    }

    cout << res;
    
    return 0;
}