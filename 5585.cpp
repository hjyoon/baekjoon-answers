#include <iostream>

using namespace std;


int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int a = 0;
    cin >> a;

    a = 1000 - a;

    int cnt = a / 500;
    a = a % 500;
    cnt += a / 100;
    a = a % 100;
    cnt += a / 50;
    a = a % 50;
    cnt += a / 10;
    a = a % 10;
    cnt += a / 5;
    a = a % 5;
    cnt += a / 1;

    cout << cnt;

    return 0;
}