#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int sum_a = 0;
 	int sum_b = 0;

	for(int i=0; i<4; i++) {
		int tmp = 0;
		cin >> tmp;
		sum_a += tmp;
	}

	for(int i=0; i<4; i++) {
		int tmp = 0;
		cin >> tmp;
		sum_b += tmp;
	}

	cout << ((sum_a>=sum_b)?(sum_a):(sum_b));

	return 0;
}