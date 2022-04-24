#include <iostream>
#include <cmath>

using namespace std;

int main() {
    freopen("input.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    long long n = 0, m = 0;
    cin >> n >> m;

    long long res = 0;

    long c = max(n, m) - min(n, m) + 1;

    res = (c*(n+m))/2;

    cout << res;
    
    
    return 0;
}