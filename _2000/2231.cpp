#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	int N = 0;
	vector<pair<int,int>> v;

	cin >> N;
	for(int i=0; i<N; i++) {
		int first = 0, second = 0;
		cin >> first >> second;
		pair<int,int> p = make_pair(first, second);
		v.push_back(p);
	}

	vector<int> res(N, 1);
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			if(i == j) {
				continue;
			}

			if(v[i].first < v[j].first && v[i].second < v[j].second) {
				res[i]++;
			}
		}
	}

	for(int i=0; i<res.size(); i++) {
		cout << res[i] << endl;
	}



	return 0;
}