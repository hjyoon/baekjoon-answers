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

	int xx1=0, yy1=0;
	int xx2=0, yy2=0;

	if(x1 == x2) {
		xx1 = x3;
		yy1 = y3;
	}
	else if(x1 == x3) {
		xx1 = x2;
		yy1 = y2;
	}
	else {
		xx1 = x1;
		yy1 = y1;
	}

	if(y1 == y2) {
		yy2 = y3;
		xx2 = x3;
	}
	else if(y1 == y3) {
		yy2 = y2;
		xx2 = x2;
	}
	else {
		yy2 = y1;
		xx2 = x1;
	}

	int n_x1 = xx1, n_y1 = yy2;
	int n_x2 = xx2, n_y2 = yy1;

	if(!(n_x1 == x1 && n_y1 == y1)) {
		if(!(n_x1 == x2 && n_y1 == y2)) {
			if(!(n_x1 == x3 && n_y1 == y3)) {
				cout << n_x1 << ' ' << n_y1 << endl;
				return 0;
			}
		}
	}

	if(!(n_x2 == x1 && n_y2 == y1)) {
		if(!(n_x2 == x2 && n_y2 == y2)) {
			if(!(n_x2 == x3 && n_y2 == y3)) {
				cout << n_x2 << ' ' << n_y2 << endl;
				return 0;
			}
		}
	}

	return 0;
}