#include <iostream>
#include <algorithm>

using namespace std;

unsigned long long solve1(int n, int l, auto& d) {
	if(d[n][l] != 0 || n == 1) {
		return d[n][l];
	}

	if(l == 0) {
		d[n][l] = solve1(n-1, l+1, d) % 1000000000;
		return d[n][l];
	} else if(l == 9) {
		d[n][l] = solve1(n-1, l-1, d) % 1000000000;
		return d[n][l];
	} else {
		d[n][l] = (solve1(n-1, l-1, d) + solve1(n-1, l+1, d)) % 1000000000;
		return d[n][l];
	}
	
}

unsigned long long solve_f(int n, auto& d) {
	for (int i=1; i<=9; i++) {
        d[1][i] = 1;
    }

    if (n > 1) {
	    for (int i=0; i<=9; i++) {
	        d[n][i] = solve1(n, i, d);
	    }
	}


	unsigned long long ans = 0;
    for (int i=0; i<=9; i++) {
        ans += d[n][i];
    	ans %= 1000000000;
    }
    return ans;
}

// unsigned long long solve2(int n, auto& d) {
// 	for (int i=1; i<=9; i++) {
//         d[1][i] = 1;
//     }
// 	for (int i=2; i<=n; i++) {
//         for (int j=0; j<=9; j++) {
//             d[i][j] = 0;
//             if (j-1 >= 0) {
//                 d[i][j] += d[i-1][j-1];
//             }
//             if (j+1 <= 9) {
//                 d[i][j] += d[i-1][j+1];
//             }
//             d[i][j] %= 1000000000;
//         }
//     }
	
// 	unsigned long long ans = 0;
//     for (int i=0; i<=9; i++) {
//         ans += d[n][i];
//     	ans %= 1000000000;
//     }
//     return ans;
// }

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	unsigned long long d[101][10] = {0, };

	auto res1 = solve_f(n, d);
	cout << res1 << '\n';
	//auto res2 = solve2(n, d);
	//cout << res2 << '\n';

	for(int i=0; i<101; i++) {
		for(int j=0; j<10; j++) {
			cout << d[i][j] << ' ';
		}
		cout << '\n';
	}

	return 0;
}