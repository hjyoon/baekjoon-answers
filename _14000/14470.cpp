#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int A=0, B=0, C=0, D=0, E=0;
	cin >> A >> B >> C >> D >> E;

	if(A < 0) {
		int tmp = 0-A;
		int s = tmp*C;
		s += D;
		s += (B*E);
		cout << s;
	}
	else {
		int tmp = B-A;
		cout << E*tmp;
	}

	return 0;
}