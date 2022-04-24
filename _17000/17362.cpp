#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n=0;
	cin >> n;

	int res = ((n-1)%8)+1;

	if(res > 5) {
		cout << 10-res;
	}
	else {
		cout << res;
	}

	return 0;
}