#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N=0, T=0, C=0, P=0;
	cin >> N >> T >> C >> P;

	int per = P*C;

	int res = ((N-1)/T)*per;

	cout << res;

	return 0;
}