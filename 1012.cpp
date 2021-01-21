#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
int N, M, K;

void dfs(int x, int y, int a[][50], bool check[][50]) {
    check[y][x] = true;
    for (int k=0; k<4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        if(nx < M && ny < N && nx >= 0 && ny >= 0) {
            if (check[ny][nx] == false && a[ny][nx] == 1) {
                dfs(nx, ny, a, check);
            }
        }
    }
}

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while(T--) {
        int a[50][50] = {0, };
        bool check[50][50] = {0, };

        cin >> M >> N >> K;
        for(int i=0; i<K; i++) {
            int X = 0, Y = 0; 
            cin >> X >> Y;
            a[Y][X] = 1;
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check[i][j] == false && a[i][j] == 1) {
                    dfs(j, i, a, check);
                    cnt++;
                    //cout << i << ' ' << j << '\n';
                }
            }
        }

        cout << cnt << '\n';
    }
	

	return 0;
}