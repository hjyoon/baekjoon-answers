#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int s=0, k=0, h=0;
	cin >> s >> k >> h;

	if(s+k+h >= 100) {
		cout << "OK";
	}
	else {
		if(s < k && s < h) {
			cout << "Soongsil";
		}
		else if(k < s && k < h) {
			cout << "Korea";
		}
		else {
			cout << "Hanyang";
		}
	}

	return 0;
}