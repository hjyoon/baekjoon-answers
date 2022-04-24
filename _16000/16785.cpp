#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a=0, b=0, c=0;
	cin >> a >> b >> c;

	int res = 0;
	int s = 0;
	int d = 0;
	while(1) {
		if(s >= c) {
			res = d;
			break;
		}
		else {
			d++;
			s += a;
			if(d%7 == 0) {
				s += b;
			}
		}
	}

	cout << res;

	return 0;
}