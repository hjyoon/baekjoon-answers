#include <iostream>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	for(int i=1; i<=n; i++) {
		for(int j=1; j<=(n-i); j++) {
			cout << ' ';
		}
		for(int j=1; j<=(i*2)-1; j++) {
			if(j==1 || j==(i*2)-1 || i==n) {
				cout << '*';
			}else{
				cout << ' ';
			}
		}
		cout << '\n';
	}

	return 0;
}