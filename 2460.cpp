#include <iostream>

using namespace std;


int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int a[10][2] = {0, };
    for (int i = 0; i < 10; i++) {
        cin >> a[i][0] >> a[i][1];
    }

    int current = 0;
    int max = 0;
    for(int i=0; i<10; i++) {
        current -= a[i][0];
        current += a[i][1];
        if(max < current) {
            max = current;
        }
    }

    // for(int i=1; i<=N; i++) {
    //     cout << a[i] << ' ';
    // }

    cout << max;


    return 0;
}