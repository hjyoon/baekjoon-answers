#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long R=0, C=0, N=0;
	cin >> R >> C >> N;

	long long res = ((R+N-1)/N) * ((C+N-1)/N);

	cout << res;

	return 0;
}