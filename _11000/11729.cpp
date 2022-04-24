#include <iostream>

using namespace std;

void solve(int n, int x, int y) {
    if (n == 0) 
    	return;
    solve(n-1, x, 6-x-y);
    cout << x << ' ' << y << '\n';
    solve(n-1, 6-x-y,y);
}

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;

    cin >> n;

    cout << (1<<n)-1 << '\n';

    solve(n, 1, 3);

    return 0;
}