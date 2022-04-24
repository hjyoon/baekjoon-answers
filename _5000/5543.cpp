#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N = 0;
	cin >> N;

	int cnt = 0;
	int x=0, y=0, z=0;

	for(int i=1;i<N;i++) {
		for(int j=2;j<N;j++) {
			z = i;
			y = z + j;
			x = N-y-z;
			if(x<1 || x+y+z>N || x%2!=0) {
				continue;
			}
			else {
				cnt++;
				//cout << x << ' ' << y << ' ' << z << '\n';
			}
		}
	}

	cout << cnt;
	

	return 0;
}