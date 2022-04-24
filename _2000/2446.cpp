#include <iostream>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	for(int i=0; i<n; i++) {
		for(int j=0;j<i;j++) {
			cout << ' ';
		}
		for(int j=0;j<((n-i)*2)-1;j++) {
			cout << '*';
		}
		cout << '\n';
	}

	for(int i=1; i<n; i++) {
		for(int j=0;j<(n-1)-i;j++) {
			cout << ' ';
		}
		for(int j=0;j<((i+1)*2)-1;j++) {
			cout << '*';
		}
		cout << '\n';
	}

	return 0;
}