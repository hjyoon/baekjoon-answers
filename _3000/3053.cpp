#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	double R = 0;
	cin >> R;

	cout.precision(6); 
	cout.setf(ios::fixed);

	cout << R*R*3.14159265358979 << endl;
	cout << pow(R*2, 2)/2;

	return 0;
}