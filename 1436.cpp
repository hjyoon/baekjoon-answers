#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

bool check(string s) {
    if(s.find("666") != ::string::npos) {
        return true;
    }

    return false;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0;

    cin >> N;

    int cnt = 0;
    for(int i=666; i<=10000666; i++) {
        if(check(::to_string(i))) {
            cnt++;
            if(cnt == N) {
                cout << i;
                break;
            }
        }
    }

    return 0;
}