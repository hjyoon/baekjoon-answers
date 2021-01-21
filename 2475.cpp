#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int total = 0;

	for(int i=0; i<5; i++) {
		int tmp = 0;
		cin >> tmp;
		total += tmp*tmp;
	}

	cout << total%10;

	return 0;
}