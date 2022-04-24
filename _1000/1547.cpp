#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int arr[3] = {1, 0, 0};

	int N = 0;
	cin >> N;
	for(int i=0; i<N; i++) {
		int a=0, b=0;
		cin >> a >> b;
		swap(arr[a-1], arr[b-1]);
	}

	for(int i=0; i<3; i++) {
		if(arr[i] == 1) {
			cout << i+1;
		}
	}

	return 0;
}