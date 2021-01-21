#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;

    int fac = 1;

    for(int i=n; i>=1; i--) {
        fac *= i;
    }

    cout << fac;

    return 0;
}