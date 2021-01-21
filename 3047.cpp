#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);
	int n[3];
	cin >> n[0] >> n[1] >> n[2];

	sort(n, n+3);

	int A, B, C;
	A = n[0];
	B = n[1];
	C = n[2];

	string s;
	cin >> s;

	for(int i=0; i<3; i++) {
		if(s[i] == 'A') {
			cout << A << ' ';
		} else if(s[i] == 'B') {
			cout << B << ' ';
		} else {
			cout << C << ' ';
		}
	}

	cout << '\n';
	return 0;
}