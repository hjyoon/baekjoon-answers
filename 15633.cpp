#include <iostream>
using namespace std;
int main() {
    int n = 0;
    cin >> n;
    int sum = 0;
    for(int i=1; i<=n; i++) {
        if(n%i == 0) {
            sum += i;
        }
    }
    cout << sum * 5 - 24;
    return 0;
}