#include <iostream>
#include <string>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	int n = 0;

	cin >> n;

	if(n < 3) {
		cout << "ongoing";
		return 0;
	}

	string s[n];
	for(int i=0; i<n; i++) {
		cin >> s[i];
	}

	int y[8] = {0,0,1,2,1,2,1,2};
	int x[8] = {1,2,1,2,0,0,-1,-2};

	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			int cnt = 0;
			char cmp = s[i][j];
			if(cmp == '.') {
				continue;
			}
			for(int k=0; k<8; k++) {
				int next_y = y[k];
				int next_x = x[k];
				if(i+next_y >= n || j+next_x >= n || j+next_x < 0) {
					cnt = 0;
					continue;
				}
				else {
					if(s[i+next_y][j+next_x] == cmp) {
						cnt++;
						//cout << "i = " << i << ' ' << "j = " << j << '\n';
						//cout << "next_y = " << next_y << ' ' << "next_x = " << next_x << '\n';
						//cout << "cnt = " << cnt << '\n';
						if(cnt >= 2) {
							//cout << i << ' ' << j << '\n';
							cout << cmp;
							return 0;
						}
					}
					else {
						cnt = 0;
					}
				}
			}
		}
	}

	cout << "ongoing";

	return 0;
}