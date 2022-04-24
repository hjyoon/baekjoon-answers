#include <iostream>

using namespace std;

int main() {
    freopen("input.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = 0;
    cin >> n;

    int Y = 0;
    int M = 0;

    for(int i=0; i<n; i++) {
        int tmp = 0;
        cin >> tmp;

        Y = Y + ((tmp/30)+1)*10;
        M = M + ((tmp/60)+1)*15;
    }

    if(Y > M) {
        cout << "M " << M;
    }
    else if(Y < M) {
        cout << "Y " << Y;
    }
    else {
        cout << "Y M " << Y;
    }
    
    
    return 0;
}