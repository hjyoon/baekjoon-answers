#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int x1=0, y1=0, z1=0;
	int x2=0, y2=0, z2=0;
	cin >> x1 >> y1 >> z1;
	cin >> x2 >> y2 >> z2;

	cout << x2-z1 << ' ' << y2/y1 << ' ' << z2-x1;

	return 0;
}