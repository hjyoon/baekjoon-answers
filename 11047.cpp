#include <iostream>

using namespace std;

int a[10];

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

	int n, k;
	cin >> n >> k;
	
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}

	int ans = 0;
	for(int i=n-1; i>-1; i--) {
		int tmp = k / a[i];
		ans += tmp;
		k -= tmp * a[i];
	}

	cout << ans;

	return 0;
}