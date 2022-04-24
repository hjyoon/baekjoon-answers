#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while(T--) {
        int a = 0;
        int b = 0;

        unsigned long long tmp = 1;
        cin >> a >> b;

        b = b%4;
        if(b == 0) {
            b = 4;
        }

        for(int i=0; i<b; i++) {
            tmp = tmp * a;
        }

        tmp %= 10;
        
        if(tmp == 0) {
            cout << 10 << '\n';
        } else {
            cout << tmp << '\n';
        }
        
    }

    return 0;
}