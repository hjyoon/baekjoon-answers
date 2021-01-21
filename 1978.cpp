#include <iostream>

using namespace std;

bool is_prime(int x) {
    if (x < 2) {
        return false;
    }

    for (int i=2; i*i <= x; i++) {
        if (x % i == 0) {
            return false;
        }
    }
    
    return true;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;
    
    int cnt = 0;
    for (int i=0; i<n; i++) {
        int num;
        cin >> num;
        if (is_prime(num)) {
            cnt += 1;
        }
    }

    cout << cnt << '\n';
    return 0;
}