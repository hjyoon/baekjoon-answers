#include <iostream>

using namespace std;

int main() {
    freopen("input.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int max = -1;
    int w=0, h=0;

    for(int i=1; i<=9; i++) {
        for(int j=1; j<=9; j++) {
            int tmp = 0;
            cin >> tmp;
            if(tmp > max) {
                max = tmp;
                w=j;
                h=i;
            }
        }
    }

    cout << max << '\n';
    cout << h << ' ' << w;
    
    
    return 0;
}