#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int N = 0;
    int F = 0;

    cin >> N;
    cin >> F;

    N = N/100 * 100;

    int ans = 0;

    if(N%F==0) {
        ans = 0;
    } else {
        ans = ((N/F)+1)*F;
        ans %= 100;
    }

    cout.fill('0');
    cout.width(2);
    cout << ans;

    return 0;
}