#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n=0, a=0, b=0, c=0, d=0;
	cin >> n >> a >> b >> c >> d;

	int res1 = ((n-1)/a+1)*b;
	int res2 = ((n-1)/c+1)*d;

	if(res1 > res2) {
		cout << res2;
	}
	else {
		cout << res1;
	}

	return 0;
}