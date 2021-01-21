#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    cout << 5-5/3*3 << '\n';

    int b[2][3] = {1,2,3,4,5,6};
    cout << *b+2 << '\n';

	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while(T--) {
        int N = 0, K = 0;
        int time[1000] = {0, }, pre[1000] = {0, };
        vector<int> suc[1000];

        cin >> N >> K;

        for(int i=0; i<N; i++) {
            cin >> time[i];
        }

        for(int i=0; i<K; i++) {
            int X = 0, Y = 0;
            cin >> X >> Y;
            suc[X-1].push_back(Y-1);
            pre[Y-1]++;
        }

        int W = 0;
        cin >> W;
        W--;

        // result: 해당 건물을 짓기 시작하는 데 걸리는 최소 시간
        int result[1000] = {0};
        queue<int> Q;

        // 선행자가 하나도 없는 노드들을 먼저 큐에 push
        for(int i=0; i<N; i++) {
            if(!pre[i]) {
                Q.push(i);
            }
        }
 
        // W번 건물의 선행자가 하나도 없을 때까지(더 갱신될 여지가 없음)
        while(pre[W] > 0){
            int u = Q.front();
            Q.pop();

            // 모든 후행자 건물의 최소 건설시작시간을 갱신
            for(int next: suc[u]){
                result[next] = max(result[next], result[u]+time[u]);
                if(--pre[next] == 0) {
                    Q.push(next);
                }
            }
        }

        // 목표 건물을 짓는 데 걸리는 시간도 더해야 함
        cout << result[W]+time[W] << '\n';
    }

	return 0;
}