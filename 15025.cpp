#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int L=0, R=0;
	cin >> L >> R;

	if(L == 0 && R == 0) {
		cout << "Not a moose";
		return 0;
	}

	if(L == R) {
		cout << "Even " << L+R;
	}
	else {
		cout << "Odd " << ((L>R)?(L*2):(R*2));
	}

	return 0;
}