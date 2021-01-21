#include <iostream>
#include <cmath>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long n = 0;
	cin >> n;

	long double res = sqrt(n);

	cout.precision(8);

	cout << fixed << res*4;

	return 0;
}