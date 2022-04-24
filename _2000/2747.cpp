#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int num[46] = {0, };
	num[0] = 0;
	num[1] = 1;

	for(int i=2; i<=45; i++) {
		num[i] = num[i-1] + num[i-2];
	}

	int n;
	cin >> n;
	cout << num[n];


	return 0;
}