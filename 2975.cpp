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

    while(1) {
        int a=0, b=0;
        char c=0;

        cin >> a >> c >> b;
        if(a ==0 && c == 'W' && b ==0) {
            break;
        }

        int res = 0;
        bool s;

        if(c == 'W') {
            if(a-b < -200) {
                s = false;
            } else {
                s = true;
                res = a - b;
            }
        } else if(c == 'D') {
            s = true;
            res = a + b;
        }

        if(s == true) {
            cout << res << '\n';
        } else {
            cout << "Not allowed" << '\n';
        }
    }

    return 0;
}