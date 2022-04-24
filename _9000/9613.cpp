#include <iostream>
#include <vector>

using namespace std;

// int gcd(int x, int y) {
// 	if (y == 0) {
// 		return x;
// 	} else {
// 		return gcd(y, x%y);
// 	}
// }

int gcd(int x, int y) {
	while(y != 0) {
		int r = x%y;
		x = y;
		y = r;
	}
	return x;
}

int lcm(int x, int y) {
	int g = gcd(x, y);
	return g * x/g * y/g;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

    int t;
    cin >> t;

    for(int i=0; i<t; i++) {
    	int x, y;
    	int n;
    	cin >> n;
    	vector<long long> vec;

    	for(int j=0; j<n; j++) {
    		int tmp;
    		cin >> tmp;
    		vec.push_back(tmp);
		}

		long long sum = 0;

		for(int k=0; k<n; k++) {
			for(int l=k+1; l<n; l++) {
	    		sum += gcd(vec[k], vec[l]);
	    	}
		}

		cout << sum << '\n';
    }

	return 0;
}
