#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a=0, b=0, c=0, d=0;
	cin >> a >> b >> c >> d;

	int arr[4] = {a, b, c, d};

	if(a > d && b > a) {
		arr[0] = c;
		arr[1] = d;
		arr[2] = a;
		arr[3] = b;
	}

	if(is_sorted(arr, arr+4)) {
		cout << arr[1] - arr[0] + arr[3] - arr[2];
		return 0;
	}

	sort(arr, arr+4);

	cout << arr[3] - arr[0];

	return 0;
}