#include <iostream>

using namespace std;

const long long mod = 1000000;
const long long p = mod/10*15;
long long fibo[p] = {0,1};

long long main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	long long n;
    cin >> n;
    for (long long i=2; i<p; i++) {
        fibo[i] = fibo[i-1] + fibo[i-2];
        fibo[i] %= mod;
    }
    cout << fibo[n%p];
    return 0;
}