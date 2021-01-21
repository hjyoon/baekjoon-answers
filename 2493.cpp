#include <iostream>
#include <vector>
#include <utility>
#include <stack>

using namespace std;

int a[500000];
int res[500000];

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	stack<pair<int, int>> s;
	for (int i = 0; i < n; i++) {
		pair<int, int> p = { i + 1, a[i] };

		while (!s.empty()) {
			if (s.top().second < a[i]) {
				s.pop();
			}
			else {
				res[i] = s.top().first;
				break;
			}
		}

		s.push(p);
	}

	for (int i = 0; i < n; i++) {
		cout << res[i] << ' ';
	}

	return 0;
}