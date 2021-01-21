#include <iostream>

using namespace std;

int map[100][100];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n = 0;
    cin >> n;

    for(int i=0; i<n; i++) {
        int x = 0, y = 0;
        cin >> x >> y;

        for(int j=y; j<y+10; j++) {
            for(int k=x; k<x+10; k++) {
                map[j][k] = 1;
            }
        }
    }

    int res = 0;

    for(int i=0; i<100; i++) {
        for(int j=0; j<100; j++) {
            if(map[i][j] == 1) {
                res++;
            }
        }
    }

    cout << res;

    return 0;
}