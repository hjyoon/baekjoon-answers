#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	map<string, int> m = {
		{"black", 0}, {"brown", 1}, {"red", 2},
		{"orange", 3}, {"yellow", 4}, {"green", 5},
		{"blue", 6}, {"violet", 7}, {"grey", 8},
		{"white", 9}
	};

	string a, b, c;
	cin >> a >> b >> c;

	long long res;
	res = (10*m[a]) + m[b];

	for(int i=0; i<m[c]; i++) {
		res *= 10;
	}

	cout << res;

	return 0;
}