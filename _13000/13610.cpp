#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int A=0, B=0;
	cin >> A >> B;

	int sub = B-A;

	cout << (B+sub-1)/sub;

	return 0;
}