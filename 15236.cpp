#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N=0;
	cin >> N;

	int cnt = 0;

	for(int i=1; i<=N; i++) {
		for(int j=0; j<=i; j++) {
			cnt += (i+j);
		}
	}

	cout << cnt;

	return 0;
}