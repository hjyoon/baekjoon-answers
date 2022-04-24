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

    int arr[24] = {0, };
    int temp = 1;

    for(int i=0; i<24; i++) {
        arr[i] = temp;
        temp *= 2;
    }

    while(T--) {
        string s;
        //cin.clear();
        //cin.ignore();

        cin >> s;
        //getline(cin, s);
        //cout << s << " = ";

        int res = 0;
        int l = s.length();
        for(int i=0; i<l; i++) {
            char tmp = s[l-(i+1)];
            if(tmp == '0') {
                continue;
            } else if(tmp == '1') {
                res += arr[i];
            }
        }

        cout << res << '\n';
    }

    return 0;
}