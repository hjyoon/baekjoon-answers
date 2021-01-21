#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	int n = 0;
	cin >> n;

	int y = 1, x = 1;

	for(int i=0; i<n; i++) {
		x<=y?x++:y++;
	}

	cout << y*x;

	return 0;
}