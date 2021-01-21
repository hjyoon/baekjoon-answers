#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	int m = 0;
	cin >> m;

	int max = m;

	for(int i=0; i<n; i++) {
		int a = 0, b = 0;
		cin >> a >> b;
		m += a;
		m -= b;
		if(m < 0) {
			max = 0;
			break;
		}
		else if(max < m) {
			max = m;
		}
	}

	cout << max;
	

	return 0;
}