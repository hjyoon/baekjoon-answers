#include <iostream>

using namespace std;

int main() {
	freopen("ouput.txt", "w", stdout);
	int a = 0;

	//cin >> a;

	for(int a=3; a<=5000; a++) {
			if(a == 4 || a == 7) {
			cout << -1 << '\n';
			//return 0;
			continue;
		} 

		int res = a/5;


		if(a%5 == 1) {
			res++;
		} 
		else if(a%5 == 2) {
			res += 2;
		}
		else if(a%5 == 3) {
			res++;
		}
		else if(a%5 == 4) {
			res += 2;
		}

		cout << res << '\n';
	}
	

	return 0;
}