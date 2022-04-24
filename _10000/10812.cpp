#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N, M;
	cin >> N >> M;

	vector<int> a;

	for(int i=1; i<=N; i++) {
		a.push_back(i);
	}

	for(int i=0; i<M; i++) {
		{
			int i, j, k;
			cin >> i >> j >> k;
			i -= 1;
			k -= 1;
			rotate(a.begin()+i, a.begin()+k, a.begin()+j);
		}
	}

	for(int x : a) {
		cout << x << ' ';
	}

	return 0;
}