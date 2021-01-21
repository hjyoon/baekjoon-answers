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

    int N=0, M=0;
    cin >> N >> M;

    queue<int> q;

    for(int i=1; i<=N; i++) {
        q.push(i);
    }

    cout << '<';
    while(1) {
        if(q.size() == 1) {
            cout << q.front();
            break;
        }

        for(int i=0; i<M-1; i++) {
            q.push(q.front());
            q.pop();
        }

        cout << q.front() << ", ";
        q.pop();
    }
    cout << '>';

    return 0;
}