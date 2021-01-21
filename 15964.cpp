#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	long long int A=0, B=0;
	cin >> A >> B;
	cout << (A+B)*(A-B);

	return 0;
}