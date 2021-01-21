#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<pair<int,int>> a[201];
bool check[201];

void dfs(int node) {
    check[node] = true;
    cout << node << ' ';
    for (int i=0; i<a[node].size(); i++) {
        int next = a[node][i].first;
        if (check[next] == false) {
            dfs(next);
        }
    }
}

void bfs(int start) {
    queue<int> q;
    memset(check,false,sizeof(check));
    check[start] = true;
    q.push(start);
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << ' ';
        for (int i=0; i<a[node].size(); i++) {
            int next = a[node][i].first;
            if (check[next] == false) {
                check[next] = true;
                q.push(next);
            }
        }
    }
}

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //for(int k=1; k<=F; k++) {
    //char input_file_name[128] = "";
    //sprintf(input_file_name, "C:\\Users\\hjyoon\\Desktop\\testcase\\input_data\\input-made%d.txt", 1);
	freopen("input.txt", "r", stdin);

	//char output_file_name[128] = "";
	//sprintf(output_file_name, "C:\\Users\\hjyoon\\Desktop\\testcase\\output_data\\output_test.txt", k);
	//freopen(output_file_name, "a", stdout);

	int N = 0, M = 0, K = 0;
	cin >> N >> M >> K;

	for(int i=0; i<M; i++) {
		int u=0, v=0, w=0;
		cin >> u >> v >> w;
		a[u].push_back(make_pair(v, w));
		a[v].push_back(make_pair(u, w));
	}

	for(int i=0; i<K; i++) {
		int tmp = 0;
		cin >> tmp;
		cin >> tmp;
	}

	dfs(1);
	cout << '\n';
	bfs(1);

	return 0;
}