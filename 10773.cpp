#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int K=0;
    cin >> K;

    stack<int> s;
    for(int i=0; i<K; i++) {
        int tmp = 0;
        cin >> tmp;
        if(tmp != 0) {
            s.push(tmp);
        } else {
            s.pop();
        }
    }

    int sum = 0;

    while(!s.empty()) {
        sum += s.top();
        s.pop();
    }

    cout << sum;

    return 0;
}