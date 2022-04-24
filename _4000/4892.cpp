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

    int cnt=1;
    while(1) {
        int n0 = 0;
        cin >> n0;

        if(n0 == 0) {
            break;
        }

        int n1 = 0;
        n1 = n0*3;

        int n2 = 0;
        if(n1%2==0) {
            n2 = n1/2;
        } else {
            n2 = (n1+1)/2;
        }

        int n3 = n2*3;
        int n4 = n3/9;

        int res = 0;
        if(n1%2 == 0) {
            res = n4*2;
            cout << cnt++ << ". " << "even " << n4 << '\n';
        } else {
            res = n4*2+1;
            cout << cnt++ << ". " << "odd " << n4 << '\n'; 
        }

    }

    return 0;
}