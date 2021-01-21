#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);
	int T = 0;
	cin >> T;

	while(T--) {
		string s;
		cin >> s;

		int len = s.length();
		int side = (int)sqrt((double)len);

		vector<string> v;
		for(int i=0; i<side; i++) {
			//v[i] = s.substr(i*5, i*5+4);
			//v[i] = "hello";
			v.push_back(s.substr(i*side, side));
		}

		for(int i=side-1; i>-1; i--) {
			for(int j=0; j<side; j++) {
				cout << v[j][i];
			}
		}

		cout << '\n';
	}

	return 0;
}