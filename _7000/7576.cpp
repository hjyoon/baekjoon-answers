#include <cstdio>
#include <iostream>
#include <queue>

using namespace std;

int n,m;
int a[1000][1000];
int dist[1000][1000];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
queue<pair<int,int>> q;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    cin >> m >> n;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin >> a[i][j];
            dist[i][j] = -1;
            if(a[i][j] == 1) {
            	q.push(make_pair(i, j));
            	dist[i][j] = 0;
            }
        }
    }

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }

    int max = 0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
        	cout << dist[i][j] << ' ';
        	if (max < dist[i][j]) {
                max = dist[i][j];
            }
        }
        cout << '\n';
    }

    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if (a[i][j] == 0 && dist[i][j] == -1) {
                max = -1;
            }
        }
    }

    cout << max << '\n';

    return 0;
}