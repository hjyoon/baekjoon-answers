#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a=0, b=0;
	cin >> a >> b;

	int total = a*b;

	for(int i=0; i<5; i++) {
		int tmp = 0;
		cin >> tmp;
		cout << tmp-total << ' ';
	}

	return 0;
}