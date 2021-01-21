#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	for(int i=0; i<3; i++) {
		int h1=0, m1=0, s1=0;
		int h2=0, m2=0, s2=0;

		cin >> h1 >> m1 >> s1;
		cin >> h2 >> m2 >> s2;

		int start = h1*3600 + m1*60 + s1;
		int end = h2*3600 + m2*60 + s2;

		int res = end-start;

		cout << res/3600 << ' ' << res%3600/60 << ' ' << res%3600%60 << '\n';
	}

	return 0;
}