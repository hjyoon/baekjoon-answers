#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n=0;
	cin >> n;

	cout << (n*n*n + 3*n*n + 2*n) / 2;

	return 0;
}