#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N=0, M=0, K=0;
	cin >> N >> M >> K;

	cout << K/M << ' ' << K%M;

	return 0;
}