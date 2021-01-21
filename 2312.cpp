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

    int T=0;
    cin >> T;

    while(T--) {
        int tmp=0;
        cin >> tmp;

        int i = 2;
        int d[100001] = {0, };
        while(1) {
            if(tmp%i==0) {
                tmp = tmp/i;
                d[i]++;
                i = 2;
            } else {
                i++;
            }

            if(tmp == 1) {
                break;
            }
        }

        for(int i=2; i<=100000; i++) {
            if(d[i]) {
                cout << i << ' ' << d[i] << '\n';
            }
        }
    }

    return 0;
}