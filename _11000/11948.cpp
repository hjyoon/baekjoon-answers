#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int arr1[4] = {0, };
	int arr2[2] = {0, };
	
	for(int i=0; i<4; i++) {
		cin >> arr1[i];
	}

	for(int i=0; i<2; i++) {
		cin >> arr2[i];
	}

	sort(arr1, arr1+4);
	sort(arr2, arr2+2);

	cout << arr1[3] + arr1[2] + arr1[1] + arr2[1];

	return 0;
}