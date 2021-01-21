#include <iostream>

using namespace std;

int house[1001][4];	// 1:R, 2:G, 3:B

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N = 0;

	cin >> N;

	cin >> house[1][1];
	cin >> house[1][2];
	cin >> house[1][3];

	for(int i=2; i<=N; i++) {
		int R = 0, G = 0, B = 0;
		cin >> R;
		cin >> G;
		cin >> B;

		house[i][1] = (house[i-1][2]+R > house[i-1][3]+R) ? (house[i-1][3]+R) : (house[i-1][2]+R);
		house[i][2] = (house[i-1][1]+G > house[i-1][3]+G) ? (house[i-1][3]+G) : (house[i-1][1]+G);
		house[i][3] = (house[i-1][1]+B > house[i-1][2]+B) ? (house[i-1][2]+B) : (house[i-1][1]+B);
	}

	int a = house[N][1];
	int b = house[N][2];
	int c = house[N][3];

	if(a > b) {
		if(b > c) {
			cout << c;
		} else {
			cout << b;
		}
	} else {
		if(a > c) {
			cout << c;
		} else {
			cout << a;
		}
	}

	return 0;
}