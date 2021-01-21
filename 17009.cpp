#include <iostream>
#include <string>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);


    int A3 = 0, A2 = 0, A1 = 0;
    int B3 = 0, B2 = 0, B1 = 0;

    cin >> A3 >> A2 >> A1;
    cin >> B3 >> B2 >> B1;

    int A_Score = A3*3 + A2*2 + A1;
    int B_Score = B3*3 + B2*2 + B1;

    if(A_Score == B_Score) {
        cout << 'T';
    }
    else if(A_Score > B_Score) {
        cout << 'A';
    }
    else {
        cout << 'B';
    }

    return 0;
}