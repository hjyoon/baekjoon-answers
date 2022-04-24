#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int x=0, y=0, w=0, h=0;

    cin >> x >> y >> w >> h;

    int leng[4] = {0, };

    leng[0] = h-y;
    leng[1] = y;
    leng[2] = w-x;
    leng[3] = x;

    int min = 1000;

    for(int i=0; i<4; i++) {
        if(leng[i] < min) {
            min = leng[i];
        }
    }

    cout << min;

    return 0;
}