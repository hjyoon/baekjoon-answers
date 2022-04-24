#include <iostream>

using namespace std;

unsigned int a[500001];

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


    int N = 0;
    int cnt = 1;

    a[1] = 2;

    if(cnt % a[0] != 0)
        cout << "cnt % a[0] != 0" << '\n';

    cin >> N;
    if(N == 1) {
        cout << a[1];
        return 0;
    }

    for(int i=3; cnt!=N; i++) {
        if (is_prime(i)) {
            cnt += 1;
            a[cnt] = i;
        }
    }

    cout << a[cnt];

    return 0;
}