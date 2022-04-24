#include <iostream>

using namespace std;

int d0[41];
int d1[41];

// int fibonacci(int n) {
//     if(n==0) {
//         zero++;
//         return 0;
//     } else if (n==1) {
//         one++;
//         return 1;
//     } else {
//         return fibonacci(n-1) + fibonacci(n-2);
//     }
// }

void fibonacci(int n) {
    for(int i=3; i<=n; i++) {
        d0[i] = d0[i-1] + d0[i-2];
        d1[i] = d1[i-1] + d1[i-2];
    }
}

int main(void)
{
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    d0[0] = 1;
    d1[0] = 0;
    d0[1] = 0;
    d0[2] = 1;
    d1[1] = 1;
    d1[2] = 1;

    int T=0;
    cin >> T;
    while(T--) {
        int N=0;
        cin >> N;
        fibonacci(N);
        cout << d0[N] << ' ' << d1[N] << '\n';
    }

	return 0;
}