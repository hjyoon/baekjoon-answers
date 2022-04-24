#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;
    cin.get();

    for(int i=0; i<T; i++) {
        int tmp = 0;
        cin >> tmp;
        for(int j=0; j<tmp; j++) {
            cout << '=';
        }
        cout << '\n';
    }

    return 0;
}