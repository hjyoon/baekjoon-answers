#include <iostream>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	for(int i=0; i<n-1; i++) {
		for(int j=0;j<=i;j++) {
			cout << '*';
		}
		for(int j=0;j<(n*2)-2-(i*2);j++) {
			cout << ' ';
		}
		for(int j=0;j<=i;j++) {
			cout << '*';
		}
		cout << '\n';
	}

	for(int i=1; i<=n*2; i++) {
		cout << '*';
	}
	cout << '\n';

	for(int i=0; i<n-1; i++) {
		for(int j=0;j<(n-1)-i;j++) {
			cout << '*';
		}
		for(int j=0;j<(i*2)+2;j++) {
			cout << ' ';
		}
		for(int j=0;j<(n-1)-i;j++) {
			cout << '*';
		}
		cout << '\n';
	}

	return 0;
}