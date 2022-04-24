#include <iostream>

using namespace std;

int map[101][101];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    for(int i=0; i<4; i++) {
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        cin >> x1 >> y1 >> x2 >> y2;

        for(int j=y1; j<y2; j++) {
            for(int k=x1; k<x2; k++) {
                map[j][k] = 1;
            }
        }
    }

    int res = 0;

    for(int i=0; i<101; i++) {
        for(int j=0; j<101; j++) {
            if(map[i][j] == 1) {
                res++;
            }
        }
    }

    cout << res;

    return 0;
}