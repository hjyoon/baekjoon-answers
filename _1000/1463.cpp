#include <iostream>
#include <algorithm>

using namespace std;

int memo[1000001];

// int d(int X) {
// 	if(X == 1) {
// 		return 0;
// 	}

// 	if(memo[X] != 0) {
// 		return memo[X];
// 	}

// 	if(X%2==0 && X%3==0) {
// 		int a = d(X/2);
// 		int b = d(X/3);
// 		int c = d(X-1);
// 		memo[X] = 1 + min(a, min(b,c));
// 		return memo[X];
// 	} else if(X%2==0) {
// 		int a = d(X/2);
// 		int c = d(X-1);
// 		memo[X] = 1 + min(a, c);
// 		return memo[X];
// 	} else if(X%3==0) {
// 		int b = d(X/3);
// 		int c = d(X-1); 
// 		memo[X] = 1 + min(b, c);
// 		return memo[X];
// 	} else {
// 		int c = d(X-1);
// 		memo[X] = 1 + c;
// 		return memo[X];
// 	}

// }

int d(int X) {
	int i=0;
	for(int i=2; i<=X; i++) {
		int a, b;
		int c = memo[i-1] + 1;
		if(i%2==0 && i%3==0) {
			a = memo[i/2] + 1;
			b = memo[i/3] + 1;
			memo[i] = min(a, min(b,c));
		} else if(i%2==0) {
			a = memo[i/2] + 1;
			memo[i] = min(a, c);
		} else if(i%3==0) {
			b = memo[i/3] + 1;
			memo[i] = min(b, c);
		} else {
			memo[i] = c;
		}
	}
	return memo[X];
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int X;
	cin >> X;

	cout << d(X);

	return 0;
}