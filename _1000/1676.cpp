#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int ans = 0;
    int n;
    cin >> n;

    for (int i=5; i<=n; i*=5) {
        ans += n/i;
    }

    cout << ans << '\n';
    
    return 0;
}