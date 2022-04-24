#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	vector<pair<int, int>> v;

	for(int i=0; i<5; i++) {
		int s = 0;
		for(int j=0; j<4; j++) {
			int tmp = 0;
			cin >> tmp;
			s += tmp;
		}
		pair<int, int> p = make_pair(s, i+1);
		v.push_back(p);
	}

	sort(v.begin(), v.end());

	cout << v[4].second << ' ' << v[4].first;

	return 0;
}