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

    while(T--) {
        int n=0;
        bool s = false;
        cin >> n;
        cout << "Pairs for " << n << ": ";
        for(int i=1; i<=12; i++) {
            for(int j=i+1; j<=12; j++) {
                if(i+j == n) {
                    if(s == true) {
                        cout << ", " << i << ' ' << j;
                    } else {
                        cout << i << ' ' << j;
                        s = true;
                    }
                }
            }
        }
        cout << '\n';
    }

    return 0;
}