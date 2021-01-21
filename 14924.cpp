#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int S=0, T=0, D=0;
	cin >> S >> T >> D;

	cout << (D/(S*2))*T;

	return 0;
}