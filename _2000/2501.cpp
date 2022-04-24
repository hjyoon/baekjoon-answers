#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    freopen("input.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = 0, k = 0;
    cin >> n >> k;

    for(int i=1; i<=n; i++) {
        if(n % i == 0) {
            k--;
        }
        if(k == 0) {
            cout << i;
            break;
        }
    }

    if(k > 0) {
        cout << 0;
    }
    
    return 0;
}