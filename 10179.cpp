#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cout.setf(ios::fixed);
	cout.precision(2);
 
 	int N = 0;
 	cin >> N;

 	for(int i=0; i<N; i++) {
 		double d = 0;
 		cin >> d;
 		cout << '$' << d*0.8 << '\n';
 	}

	return 0;
}