#include <iostream>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string s;
	int cnt=0;
	while(getline(cin, s, ',')) {
		cnt++;
	}
	cout << cnt;

	return 0;
}