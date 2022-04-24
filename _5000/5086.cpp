#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	while(1) {
		int a = 0, b = 0;
		cin >> a >> b;

		if(a == 0 && b == 0) {
			break;
		}

		if(a%b==0 && b%a!=0) {
			cout << "multiple" << '\n';
		}
		else if(a%b!=0 && b%a==0) {
			cout << "factor" << '\n';
		}
		else {
			cout << "neither" << '\n';
		}
	}
	

	return 0;
}