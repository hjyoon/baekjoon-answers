#include <iostream>

using namespace std;

#define PI 3.141592

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int d1=0, d2=0;
	cin >> d1 >> d2;

	double res = d1*2 + 2.0*PI*d2;


	cout.precision(6);
	cout << fixed << res;


	return 0;
}