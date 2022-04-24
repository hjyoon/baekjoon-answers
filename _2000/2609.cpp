#include <iostream>

using namespace std;

// int gcd(int x, int y) {
// 	if (y == 0) {
// 		return x;
// 	} else {
// 		return gcd(y, x%y);
// 	}
// }

int gcd(int x, int y) {
	while(y != 0) {
		int r = x%y;
		x = y;
		y = r;
	}
	return x;
}

int lcm(int x, int y) {
	int g = gcd(x, y);
	return g * x/g * y/g;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int x, y;
	cin >> x >> y;

	cout << gcd(x, y) << '\n' << lcm(x, y);

	return 0;
}
