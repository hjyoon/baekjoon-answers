#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string s1, s2;
	cin >> s1 >> s2;

	int x=0, y=0;
	bool b = true;
	for(int i=0; i<s1.length() && b; i++) {
		for(int j=0; j<s2.length() && b; j++) {
			if(s1[i] == s2[j]) {
				b = false;
				x = i;
				y = j;
			}
		}
	}

	//cout << x << ' ' << y;

	char arr_c[s2.length()][s1.length()];
	fill(arr_c[0], arr_c[0]+s2.length()*s1.length(), '.');

	for(int i=0; i<s1.length(); i++) {
		arr_c[y][i] = s1[i];
	}

	for(int i=0; i<s2.length(); i++) {
		arr_c[i][x] = s2[i];
	}

	for(int i=0; i<s2.length(); i++) {
		for(int j=0; j<s1.length(); j++) {
			cout << arr_c[i][j];
		}
		cout << '\n';
	}

	return 0;
}