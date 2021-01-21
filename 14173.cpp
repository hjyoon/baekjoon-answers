#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int x[4] = {0, }, y[4] = {0, };
	cin >> x[0] >> y[0] >> x[1] >> y[1];
	cin >> x[2] >> y[2] >> x[3] >> y[3];

	sort(x, x+4);
	sort(y, y+4);

	int side = (x[3]-x[0])>(y[3]-y[0])?(x[3]-x[0]):(y[3]-y[0]);

	cout << side*side;

	return 0;
}