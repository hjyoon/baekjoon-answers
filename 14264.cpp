#include <iostream>
#define _USE_MATH_DEFINES
#include <cmath>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long L = 0;
	cin >> L;

	cout.precision(30);

	long double d = sin(120*M_PI/180); // 라디안 단위를 인자로 준다. (1도는 "pi/180" 라디안)
	//cout << d << '\n';
	cout << ((L*L)*d)/2.0;

	return 0;
}