#include <iostream>

using namespace std;

int CalcSum(int n, int s) {
	int mod = 0;
	int res = 0;

	while(1) {
		mod = s%n;
		res += mod;
		s = s/n;
		if() {
			break;
		}
	}
	res += s;
	return res;
}

int main() {
	for(int i=1000; i<=9999; i++) {
		int a = CalcSum(10, i);
		int b = CalcSum(12, i);
		int c = CalcSum(16, i);

		if(a == b && b == c) {
			cout << i << '\n';
		}
	}

	return 0;
}