#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int arr[30] = {0, };

	for(int i=0; i<30; i++) {
		int tmp = 0;
		cin >> tmp;
		arr[tmp-1] = 1;
	}

	for(int i=0; i<30; i++) {
		if(arr[i] == 0) {
			cout << i+1 << '\n';
		}
	}

	return 0;
}