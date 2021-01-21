#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	double a1=0, p1=0;
	double a2=0, p2=0;
	cin >> a1 >> p1;
	cin >> a2 >> p2;

	double res1 = a1/p1;
	double res2 = (a2*a2*3.141592)/p2;

	if(res1 > res2) {
		cout << "Slice of pizza";
	}
	else {
		cout << "Whole pizza";
	}

	return 0;
}