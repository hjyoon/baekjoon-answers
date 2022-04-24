#include <iostream>

using namespace std;

int main() {
	int a = 0;

	cin >> a;

	if(a == 4 || a == 7) {
		cout << -1;
		return 0;
	} 

	int res = 0;
	int five = a/5;
	int three = 0;

	while(1) {
		if(five*5 + three*3 == a) {
			res = five + three;
			break;
		}
		else if(five*5 + three*3 < a) {
			three++;
		}
		else if(five*5 + three*3 > a){
			five--;
		}
	}

	cout << res;

	return 0;
}