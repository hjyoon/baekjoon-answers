#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int n;
    cin >> n;

    int mid = n-1;
    int left = mid;
    int right = mid;

    for(int i=0; i<n; i++) {
        for(int j=0; j<2*n-1; j++) {
            if(j == left || j == right) {
                cout << "*";
            } else {
                cout << " ";
            }
        }
        left--; right++;

        if(i != n-1)
            cout << endl;
    }

    return 0;
}