#include <iostream>
 
using namespace std;
 
int main() {
    int n;
    
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n-1; j++) {
            cout << " ";
        }

        cout << "*";
        for (int k = 0; k < (2*i)-1; k++) {
            cout << " ";                                                             
        }

        if (i >= 1) {
            cout << "*";
        }

        cout << endl;
    }
 
    return 0;
}
