#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	vector<int> v;
	for(int i=0; i<n; i++) {
		int tmp = 0;
		cin >> tmp;
		v.push_back(tmp);
	}

	long long cnt = 0;
	vector<pair<int, int>> s;
	for(int i=0; i<n; i++) {
		pair<int, int> p = {v[i], 1};
		while(!s.empty()) {
			if(s.back().first <= v[i]) {
				cnt += s.back().second;
				if(s.back().first == v[i]) {
					p.second += s.back().second;
				}
				s.pop_back();
			}
			else {
				break;
			}
		}
		if(!s.empty()) {
			cnt++;
		}
		s.push_back(p);
	}

	cout << cnt;

	return 0;
}