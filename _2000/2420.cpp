#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	long long N = 0, M = 0;
	cin >> N >> M;

	long long res = N-M;

	res = (res>0)?(res):(-res);

	cout << res << '\n';

	return 0;
}