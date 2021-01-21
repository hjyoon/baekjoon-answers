#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int N = 0;
 	cin >> N;

 	if(N%10 != 0) {
 		cout << -1;
 		return 0;
 	}

 	int A = 0, B = 0, C = 0;

 	A = N/300;
 	B = (N%300)/60;
 	C = (N%60)/10;

 	cout << A << ' ' << B << ' ' << C << '\n';

	return 0;
}