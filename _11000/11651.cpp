#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

struct Point {
	int x, y;
};

bool cmp(const Point& u, const Point& v) {
	if(u.y < v.y) {
		return true;
	} else if(u.y == v.y) {
		if(u.x < v.x) {
			return true;
		} else {
			return false;
		}
	} else {
		return false;
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N;
	cin >> N;

	vector<Point> a;

	for(int i=0; i<N; i++) {
		Point tmp;
		cin >> tmp.x >> tmp.y;
		a.push_back(tmp);
	}

	sort(a.begin(), a.end(), cmp);

	for(auto x : a) {
		cout << x.x << ' ' << x.y << '\n';
	}

	return 0;
}