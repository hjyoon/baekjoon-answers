#include <iostream>
#include <list>
#include <utility>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	int n=0;

	cin >> n;

	list<pair<int, int>> l;

	for(int i=0; i<n; i++) {
		int tmp=0;
		cin >> tmp;
		auto p = make_pair(i+1, tmp);
		l.push_back(p);
	}

	// for(int i=0; i<n; i++) {
	// 	cout << l.front().first << " " << l.front().second << '\n';
	// 	l.pop_front();
	// }

	auto it = l.begin();
	for(int i=0; i<n-1; i++) {
		cout << (it->first) << ' ';	// 스타트는 무조건 1번째 부터
		int step = it->second;
		if(step > 0) {
			auto tmp = it;
			tmp++;
			if(tmp == l.end()) {
				tmp = l.begin();
			}
			l.erase(it);
			it = tmp;
			for(int i=0; i<step-1; i++) {
				it++;
				if(it == l.end()) {
					it = l.begin();
				}
			}
		} else if(step < 0) {
			step = -step;
			auto tmp = it;
			if(tmp == l.begin()) {
				tmp = l.end();
			}
			tmp--;
			l.erase(it);
			it = tmp;
			for(int i=0; i<step-1; i++) {
				if(it == l.begin()) {
					it = l.end();
				}
				it--;
			}
		}
	}

	cout << l.front().first << '\n';


	return 0;
}