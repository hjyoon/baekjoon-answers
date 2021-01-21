#include <iostream>
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
			int i,j;
			cin >> i >> j;
			i -= 1;
			reverse(a.begin()+i, a.begin()+j);
		}
	}

	for(auto x : a) {
		cout << x << ' ';
	}

	return 0;
}