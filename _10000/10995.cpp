#include <iostream>

using namespace std;

void print_odd(int x) {
    for(int i=0; i<2*x-1; i++) {
        if(i%2 == 0) {
            cout << '*';
        } else {
            cout << ' ';
        }
    }
}

void print_even(int x) {
    for(int i=0; i<2*x; i++) {
        if(i%2 == 0) {
            cout << ' ';
        } else {
            cout << '*';
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0;

    cin >> N;

    for(int i=0; i<N; i++) {
        if(i%2==0) {
            print_odd(N);
        } else {
            print_even(N);
        }
        cout << '\n';
    }

    return 0;
}