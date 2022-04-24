#include <iostream>

using namespace std;

int main() {
	freopen("../input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a=0, b=0;

	cin >> a >> b;

	cout << a/b << ' ' << a%b;

	return 0;
}