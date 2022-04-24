#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int s = 0;
	cin >> s;

	for(int i=0; i<9; i++) {
		int tmp = 0;
		cin >> tmp;
		s -= tmp;
	}

	cout << s;

	return 0;
}