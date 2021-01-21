#include <iostream>
#include <cmath>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	//cout.setf(ios::fixed);
	//cout.precision(6);
 
	double inch = 0;
	double ratio_h = 0, ratio_w = 0;

	cin >> inch >> ratio_h >> ratio_w;

	double t = inch*inch / ((ratio_h*ratio_h)+(ratio_w*ratio_w));

	t = sqrt(t);

	cout << (int)(ratio_h*t) << ' ' << (int)(ratio_w*t) << '\n';

	return 0;
}