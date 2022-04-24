#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while (T--) {
        int N = 0, M = 0;
        cin >> N >> M;

        //priority_queue<pair<int, int>> pq;
        vector<pair<int, int>> v;
        queue<pair<int, int>> q;
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            cin >> tmp;
            pair<int, int> p = make_pair(tmp, -i);
            //pq.push(p);
            v.push_back(p);
            q.push(p);
        }

        sort(v.begin(), v.end());

        int cnt = 0;
        while (1) {
            //pair<int, int> p = pq.top();
            pair<int, int> p = v.back();
            pair<int, int> tmp = q.front();

            if (p.second == tmp.second && tmp.second == -M) {
                cout << ++cnt << '\n';
                break;
                //pq.pop();
                v.pop_back();
                q.pop();
            }
            else if (p.second == tmp.second) {
                ++cnt;
                //pq.pop();
                v.pop_back();
                q.pop();
            }
            else if (p.first == tmp.first) {
                if (tmp.second == -M) {
                    cout << ++cnt << '\n';
                    break;
                }
                ++cnt;
                q.pop();
                auto iter = find(v.begin(), v.end(), tmp);
                v.erase(iter);
            }
            else {
                q.push(q.front());
                q.pop();
            }
        }
    }

    return 0;
}