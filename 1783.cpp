#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);
    
    int height, width;
    cin >> height >> width;

    if (height == 1) {
        cout << 1;
    } else if (height == 2) {
        cout << min(4, (width+1)/2);
    } else if (height >= 3) {
        if (width >= 7) {
            cout << width-2;
        } else {
            cout << min(4, width);
        }
    }

    cout << '\n';

    return 0;
}