#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	while(1) {
 		int a = 0, b = 0, c = 0;
		cin >> a >> b >> c;

		if(a == 0 && b == 0 && c == 0) {
			break;
		}

		int tmp = a;
		int i = 1;

		while(1) {
			if(tmp == c) {
				cout << i << '\n';
				break;
			}
			else if(b > 0 && tmp < c) {
				tmp += b;
				i++;
			}
			else if(b < 0 && tmp > c) {
				tmp += b;
				i++;
			}
			else {
				cout << 'X' << '\n';
				break;
			}
		}

 	}

	return 0;
}