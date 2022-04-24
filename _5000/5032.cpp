#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int e = 0;
    int f = 0;
    int c = 0;

    cin >> e >> f >> c;
    e = e + f;
    int ans = 0;

    while(e >= c) {
        ans += e/c;
        e = e/c + e%c;
    }

    cout << ans;

    return 0;
}