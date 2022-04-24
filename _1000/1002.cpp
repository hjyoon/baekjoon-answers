#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);
    int T=0;

    cin >> T;

    while(T--) {
        int x1=0, y1=0, r1=0, x2=0, y2=0, r2=0;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

        int xgap = x2-x1;
        int ygap = y2-y1;

        int d = xgap*xgap + ygap*ygap;

        int ans = 0;

        if(d == 0 && r1-r2 == 0) {
            ans = -1;
        } else if((r1-r2)*(r1-r2)<d && (r1+r2)*(r1+r2)>d) {
            ans = 2;
        } else if((r1+r2)*(r1+r2) == d || (r1-r2)*(r1-r2) == d) {
            ans = 1;
        } else if((r1+r2)*(r1+r2) < d || (r1-r2)*(r1-r2) > d) {
            ans = 0;
        }

        cout << ans << '\n';

    }

    return 0;
}