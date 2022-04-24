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

    int N=0;
    cin >> N;

    list<int> l;

    for(int i=1; i<=N; i++) {
        l.push_back(i);
    }

    while(l.size() != 1) {
        l.pop_front();
        int tmp = l.front();
        l.pop_front();
        l.push_back(tmp);
    }

    cout << l.front();

    return 0;
}