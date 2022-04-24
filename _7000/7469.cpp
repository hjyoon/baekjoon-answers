#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n, m;
	cin >> n >> m;

	vector<int> a;

	for(int i=0; i<n; i++) {
		int tmp;
		cin >> tmp;
		a.push_back(tmp);
	}

	for(int i=0; i<m; i++) {
		{
			int i,j,k;
			cin >> i >> j >> k;
			vector<int> b(a.begin()+(i-1), a.begin()+j);
			sort(b.begin(), b.end());
			cout << b[k-1] << '\n';
		}
	}

	return 0;
}