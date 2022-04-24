#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;

    cin >> T;

    while(T--) {
        int N = 0;
        cin >> N;

        int sum = 0;
        for(int i=0; i<N; i++) {
            int tmp = 0;
            cin >> tmp;
            sum += tmp;
        }
        cout << sum << '\n';
    }

    return 0;
}