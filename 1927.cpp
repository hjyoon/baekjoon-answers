#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N = 0;
	cin >> N;

	priority_queue<int, vector<int>, greater<int>> q;

	while(N--) {
		int x = 0;
		cin >> x;

		if(x == 0) {
			if(q.empty()) {
				cout << 0 << '\n';
			}
			else {
				cout << q.top() << '\n';
				q.pop();
			}
		}
		else {
			q.push(x);
		}
	}

	return 0;
}