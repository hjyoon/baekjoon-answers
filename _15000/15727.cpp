#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n=0;
	cin >> n;

	if(n%5 == 0) {
		cout << n/5;
	}
	else {
		cout << n/5+1;
	}

	return 0;
}