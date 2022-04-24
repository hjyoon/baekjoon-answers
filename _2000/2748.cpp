#include <iostream>

using namespace std;

long long main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	long long n;
	cin >> n;

	long long num[91] = {0, };
	num[0] = 0;
	num[1] = 1;

	for(long long i=2; i<=n; i++) {
		num[i] = num[i-1] + num[i-2];
	}

	
	cout << num[n];


	return 0;
}