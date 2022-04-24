#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    freopen("input.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int a[10] = {0, };

    int sa = 0, sb = 0;
    int sw = 0;

    for(int i=0; i<10; i++) {
        cin >> a[i];
    }

    for(int i=0; i<10; i++) {
        int tmp = 0;
        cin >> tmp;
        if(a[i] > tmp) {
            sa+=3;
            sw=1;
        }
        else if(a[i] < tmp) {
            sb+=3;
            sw=2;
        }
        else {
            sa++;
            sb++;
        }
    }

    cout << sa << ' ' << sb << '\n';
    
    if(sa > sb) {
        cout << 'A';
    }
    else if(sa < sb) {
        cout << 'B';
    }
    else {
        if(sw == 0) {
            cout << 'D';
        }
        else if(sw == 1) {
            cout << 'A';
        }
        else {
            cout << 'B';
        }
    }
    
    return 0;
}