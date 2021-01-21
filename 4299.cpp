#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	int a = 0, b = 0;
	cin >> a >> b;

	double x = (a+b)/2.0;
	double y = (a-b)/2.0;

	if(x-(int)x == 0 && y-(int)y == 0 && a >= b) {
		cout << x << ' ' << y;
	}
	else {
		cout << -1;
	}

	return 0;
}