#include <iostream>

using namespace std;

int main() {
    int A = 0, B = 0, V = 0;
    cin >> A >> B >> V;

    int res = V;
    int st = 1;
    int ed = V;
    int mid;

    while(st < ed) {
        mid = (st+ed) / 2;
        if((mid-1)*(A-B)+A >= V) {
            ed = mid;
            res = (res>mid)?mid:res;
        }
        else{
            st = mid + 1;
        }
        cout << mid << endl;
    }

    cout << res;

    return 0;
}