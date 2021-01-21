#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long n = 0, m = 0;
	cin >> n >> m;

	long long res = (n*m)/2;

	cout << res;

	return 0;
}