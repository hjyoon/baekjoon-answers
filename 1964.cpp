#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	int n = 0;
	cin >> n;

	if(n == 1) {
		cout << 5;
		return 0;
	}
	else if(n == 2){
		cout << 12;
		return 0;
	}

	long long res = 12;
	int s = 7;

	for(int i=0; i<n-2; i++) {
		s += 3;
		res += s;
	}

	cout << res%45678;

	return 0;
}