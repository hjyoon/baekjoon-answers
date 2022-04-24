#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int M = 0, D = 0;
 	cin >> M >> D;

 	if(M == 2) {
 		if(D == 18) {
 			cout << "Special";
 		}
 		else if(D > 18) {
 			cout << "After";
 		}
 		else {
 			cout << "Before";
 		}
 	}
 	else if(M > 2) {
 		cout << "After";
 	}
 	else {
 		cout << "Before";
 	}

	return 0;
}