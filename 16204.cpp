#include <iostream>

using namespace std;

int min(int a, int b) {
    if(a>b) {
        return b;
    } else {
        return a;
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0, M=0, K=0;

    cin >> N >> M >> K;

    int o = M;
    int x = N-M;

    int ko = K;
    int kx = N-K;

    cout << min(o, ko) + min(x, kx);

    return 0;
}