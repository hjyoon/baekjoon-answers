#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int A = 0;
    int B = 0;

    cin >> A;
    cin >> B;

    int a = A * (B%10);
    int b = A * ((B%100)/10);
    int c = A * (B/100);

    cout << a << '\n';
    cout << b << '\n';
    cout << c << '\n';

    int ans = a + b*10 + c*100;

    cout << ans;

    return 0;
}