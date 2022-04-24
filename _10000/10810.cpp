#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N, M;
	cin >> N >> M;

	vector<int> a(N);

	fill(a.begin(), a.begin()+1, 1);

	// for(int i=0; i<M; i++) {
	// 	{
	// 		int i,j,k;
	// 		cin >> i >> j >> k;
	// 		i -= 1;
	// 		fill(a.begin()+i, a.begin()+j, k);
	// 	}
	// }

	for(auto x : a) {
		cout << x << ' ';
	}

	return 0;
}