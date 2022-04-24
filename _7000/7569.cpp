#include <cstdio>
#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

int n, m, h;
int a[100][100][100];
int dist[100][100][100];
int dh[] = { 0, 0, 0, 0, 1, -1 };
int dx[] = { 0, 0, 1, -1, 0, 0 };
int dy[] = { 1, -1, 0, 0, 0, 0 };
//queue<pair<int,int>> q;
queue<tuple<int, int, int>> q;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);
    //cout << "hello" << '\n';

    cin >> m >> n >> h;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                cin >> a[i][j][k];
                dist[i][j][k] = -1;
                if (a[i][j][k] == 1) {
                    q.push(make_tuple(i, j, k));
                    dist[i][j][k] = 0;
                }
            }

        }
    }

    while (!q.empty()) {
        int z = get<0>(q.front());
        int x = get<1>(q.front());
        int y = get<2>(q.front());
        q.pop();
        for (int k = 0; k < 6; k++) {
            int nh = z + dh[k];
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nh && nh < h && 0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (a[nh][nx][ny] == 0 && dist[nh][nx][ny] == -1) {
                    dist[nh][nx][ny] = dist[z][x][y] + 1;
                    q.push(make_tuple(nh, nx, ny));
                }
            }
        }
    }

    int max = 0;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                //cout << dist[i][j] << ' ';
                if (max < dist[i][j][k]) {
                    max = dist[i][j][k];
                }
            }
        }
        //cout << '\n';
    }

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (a[i][j][k] == 0 && dist[i][j][k] == -1) {
                    max = -1;
                }
            }
        }
    }

    cout << max << '\n';

    return 0;
}