#include <iostream>

using namespace std;

int a[3000][3000];
int cnt[3];

bool same(int x, int y, int n) {
    for (int i=x; i<x+n; i++) {
        for (int j=y; j<y+n; j++) {
            if (a[x][y] != a[i][j]) {
                return false;
            }
        }
    }
    return true;
}

void solve(int x, int y, int n) {
    if (same(x, y, n)) {
        cnt[a[x][y]+1] += 1;
        return;
    }
    int m = n/3;
    for (int i=0; i<3; i++) {
        for (int j=0; j<3; j++) {
            solve(x+i*m, y+j*m, m);
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N;
    cin >> N;

    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cin >> a[i][j];
        }
    }

    solve(0, 0, N);
    for (int i=0; i<3; i++) {
        cout << cnt[i] << '\n';
    }

    return 0;
}