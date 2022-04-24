#include <iostream>
#include <string>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);


    int N = 0;

    cin >> N;

    for(int i=0; i<N; i++) {
        int n = 0;
        cin >> n;
        char c = 0;
        cin >> c;

        for(int j=0; j<n; j++) {
            cout << c;
        }
        cout << '\n';
    }

    return 0;
}