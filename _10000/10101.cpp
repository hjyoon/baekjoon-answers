#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int A = 0, B = 0, C = 0;
 	cin >> A >> B >> C;

 	int S = A + B + C;

 	if(S != 180) {
 		cout << "Error";
 	}
 	else if(A == 60 && B == 60 && C == 60){
 		cout << "Equilateral";
 	}
 	else if(A == B || A == C){
 		cout << "Isosceles";
 	}
 	else if(B == C){
 		cout << "Isosceles";
 	}
 	else {
 		cout << "Scalene";
 	}

	return 0;
}