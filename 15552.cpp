#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T=0;
    cin >> T;

    while(T--) {
        int a=0, b=0;
        cin >> a >> b;
        cout << a+b << '\n';
    }

	return 0;
}