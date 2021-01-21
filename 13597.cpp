#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int A=0, B=0;
	cin >> A >> B;

	if(A == B) {
		cout << A;
	}
	else if(A > B) {
		cout << A;
	}
	else {
		cout << B;
	}

	return 0;
}