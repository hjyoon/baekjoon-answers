#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;

    for(int i=2; i*i<=n; i++) {
        while(n%i == 0) {
            cout << i << '\n';
            n /= i;
        }
    }

    if(n > 1) {
        cout << n << '\n';
    }

    return 0;
}