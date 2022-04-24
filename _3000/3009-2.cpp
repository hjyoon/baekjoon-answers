#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	int x1=0, y1=0;
	int x2=0, y2=0;
	int x3=0, y3=0;

	cin >> x1 >> y1;
	cin >> x2 >> y2;
	cin >> x3 >> y3;

	int resx=0, resy=0;

	resx = x1 ^ x2;
	resy = y1 ^ y2;

	resx = resx ^ x3;
	resy = resy ^ y3;

	cout << resx << ' ' << resy;

	return 0;
}