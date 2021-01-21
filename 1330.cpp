#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int toDigit(char a) {
    int res;
    switch(a) {
        case '0': res = 0; break;
        case '1': res = 1; break;
        case '2': res = 2; break;
        case '3': res = 3; break;
        case '4': res = 4; break;
        case '5': res = 5; break;
        case '6': res = 6; break;
        case '7': res = 7; break;
        case '8': res = 8; break;
        case '9': res = 9; break;
        case 'A': res = 10; break;
        case 'B': res = 11; break;
        case 'C': res = 12; break;
        case 'D': res = 13; break;
        case 'E': res = 14; break;
        case 'F': res = 15; break;
    }
    return res;
}

int main() {
    //cin.tie(NULL);
    //ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    // string s;

    // getline(cin, s);

    // int res = 0;
    // int l = s.length();
    // for(int i=0; i<l; i++) {
    //     res += pow(16, i) * toDigit(s[l-(i+1)]);
    // }

    // cout << res;

    int res = 0;
    scanf("%x", &res);

    printf("%d", res);

    return 0;
}