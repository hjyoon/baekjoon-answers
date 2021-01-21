#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int h1=0, m1=0, s1=0;
	int h2=0, m2=0, s2=0;
	char c=0;
	cin >> h1 >> c >> m1 >> c >> s1;
	cin >> h2 >> c >> m2 >> c >> s2;

	int res1 = h1*3600 + m1*60 + s1;
	int res2 = h2*3600 + m2*60 + s2;

	cout << (res2-res1+86400)%86400;

	return 0;
}