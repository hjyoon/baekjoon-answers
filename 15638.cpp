#include <iostream>

using namespace std;

bool isPrimeNum(int N) {
	if(N==2) {
		return true;
	}

	for(int i=2; i<N; i++) {
		if(N%i == 0) {
			return false;
		} else {
			continue;
		}
	}
	return true;
}

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

	int N = 0;

	cin >> N;

	for(int i=2; i<=N; i++) {
		if(isPrimeNum(i) == false) {
			//cout << "No";
		} else{
			//cout << "Yes";
			cout << i << '\n';
		}
	}

	return 0;
}