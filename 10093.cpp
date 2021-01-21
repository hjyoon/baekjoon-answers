#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    //int N = 0;
    //cin >> N;

    unsigned long long A = 0, B = 0;
    cin >> A >> B;

    unsigned long long big=0, small=0;

    if(B > A) {
        big = B;
        small = A;
    } else if(B < A) {
        big = A;
        small = B;
    } else {
        cout << '0';
        return 0;
    }
    
    cout << big-small-1 << '\n';
    for(auto i=small+1; i<big; i++) {
        cout << i << ' ';
    }

    return 0;
}