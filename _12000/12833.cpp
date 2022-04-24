#include <iostream>
using namespace std;
int main() {
	int A=0, B=0, C=0;

	cin >> A >> B >> C;

	if(C % 2 == 1) {
		int res = A^B;
		cout << res;
	} else {
		cout << A;
	}


	return 0;
}