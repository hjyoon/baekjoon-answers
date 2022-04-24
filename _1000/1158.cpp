#include <iostream>
#include <queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N;
	cin >> N;

	priority_queue<int, vector<int>, greater<int>> q;

	for(int i=0; i<N; i++) {
		int tmp;
		cin >> tmp;
		if(tmp == 0) {
			if(q.size() == 0) cout << 0 << '\n';
			else {
				cout << q.top() << '\n';
				q.pop();
			}
		} else {
			q.push(tmp);
		}
	}

	return 0;
}