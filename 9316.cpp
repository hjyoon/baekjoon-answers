#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;

    for(int i=0; i<n; i++) {
        cout << "Hello World, Judge " << i+1 << "!" << '\n'; 
    }
    
    return 0;
}