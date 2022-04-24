#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N;
	cin >> N;

	vector<pair<int,int>> a;

	for(int i=0; i<N; i++) {
		int x,y;
		cin >> x >> y;
		a.push_back(make_pair(x,y));
	}

	sort(a.begin(), a.end());

	for(auto x : a) {
		cout << x.first << ' ' << x.second << '\n';
	}

	return 0;
}