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
    for(int i=0; i<n; i++) {
        int a[3] = {0, };
        cin >> a[0] >> a[1] >> a[2];
        sort(a, a+3);

        int tmp = 0;
        if(a[0] == a[1] && a[0] == a[2]) {
            tmp = 10000 + a[0]*1000;
        }
        else if(a[1] == a[0] || a[1] == a[2]) {
            tmp = 1000 + a[1]*100;
        }
        else {
            tmp = a[2]*100;
        }

        if(res < tmp) {
            res = tmp;
        }
    }
    
    cout << res;
    
    return 0;
}