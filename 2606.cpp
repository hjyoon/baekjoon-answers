#include <iostream>
#include <vector>
using namespace std;

vector<int> v[101];
bool check[101];
int cnt;

void dfs(int node) {
    check[node] = true;
    for (int i=0; i<v[node].size(); i++) {
        int next = v[node][i];
        if (check[next] == false) {
            cnt++;
            dfs(next);
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N = 0;
    cin >> N;

    int E = 0;
    cin >> E;

    for(int i=0; i<E; i++) {
        int a=0, b=0;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    dfs(1);

    cout << cnt;

    return 0;
}