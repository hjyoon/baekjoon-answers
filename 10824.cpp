#include <iostream>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string A, B, C, D;
	cin >> A >> B >> C >> D;

	A += B;
	C += D;

	unsigned long long sum = 0;
	sum += stoull(A);
	sum += stoull(C);

	cout << sum;

	return 0;
}