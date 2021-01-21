#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int n = 0;

    cin >> n;

    if(n % 2 == 0) {
        cout << "CY";
    }
    else {
        cout << "SK";   
    }

    return 0;
}