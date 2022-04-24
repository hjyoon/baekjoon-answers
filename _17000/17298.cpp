#include <iostream>
#include <vector>
#include <utility>
#include <stack>

using namespace std;

int a[1000000];
int res[1000000];

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0;
	cin >> n;

	for (int i=0; i<n; i++) {
		cin >> a[i];
	}

	stack<pair<int,int>> s;
	for(int i=0; i<n; i++) {
		pair<int,int> p = {i, a[i]};

		while(!s.empty()) {
			if(s.top().second < a[i]) {
				res[s.top().first] = a[i];
				s.pop();
			}
			else {
				break;
			}
		}

		s.push(p);
	}

	while(!s.empty()) {
		res[s.top().first] = -1;
		s.pop();
	}

	for (int i=0; i<n; i++) {
		cout << res[i] << ' ';
	}

	return 0;
}