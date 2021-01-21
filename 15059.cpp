#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a=0, b=0, c=0;
	int d=0, e=0, f=0;
	cin >> a >> b >> c;
	cin >> d >> e >> f;

	int sum = 0;

	if(d-a > 0) {
		sum += (d-a);
	}

	if(e-b > 0) {
		sum += (e-b);
	}

	if(f-c > 0) {
		sum += (f-c);
	}

	cout << sum;

	return 0;
}