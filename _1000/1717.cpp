#include <iostream>
#include <vector>
#include <utility>
#include <stack>

using namespace std;

int arr[1000001];

int Find(int x) {
	if(x == arr[x]) {
		return x;
	}
	else {
		int y = Find(arr[x]);
		arr[x] = y;
		return y;
	}
}

int Union(int x, int y) {
	x = Find(x);
	y = Find(y);
	arr[y] = x;
	return 0;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n=0, m=0;
	cin >> n >> m;

	for(int i=1; i<=n; i++) {
		arr[i] = i;
	}

	for (int i=0; i<m; i++) {
		int type=0, a=0, b=0;
		cin >> type >> a >> b;
		if(type == 0) {
			Union(a, b);
		}
		else {
			if(Find(a) == Find(b)) {
				cout << "YES" << '\n';
			}
			else {
				cout << "NO" << '\n';
			}
		}
	}

	for (int i=1; i<=n; i++) {
		cout << arr[i] << ' ';
	}

	return 0;
}