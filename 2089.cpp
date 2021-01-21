#include <cstdio>
#include <string>
#include <iostream>

using namespace std;

void go(int n) {
    cout << n << '\n';
    if(n==0) {
        return;
    }
    if (n%2 == 0) {
        go(-(n/2));
        cout << 0;
    } else {
        if (n > 0) {
            go(-(n/2));
        } else {
            go((-n+1)/2);
        }
        cout << 1;
    }
}

int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;

    if(n==0) {
        cout << 0 << '\n';
    } else {
        go(n);
    }

    return 0;
}