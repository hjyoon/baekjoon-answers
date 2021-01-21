#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	while(1) {
		int a=0, b=0;
		cin >> a >> b;
		if(a == 0 && b == 0) {
			break;
		}

		const char* res = NULL;
		res = a>b?"Yes":"No";
		cout << res << '\n';
	}

	return 0;
}