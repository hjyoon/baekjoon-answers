#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	int arr[6] = {1, 1, 2, 2, 2, 8};

	for(int i=0; i<6; i++) {
		int tmp = 0;
		cin >> tmp;
		arr[i] -= tmp;
	}

	for(int i=0; i<6; i++) {
		cout << arr[i] << ' ';
	}

	return 0;
}