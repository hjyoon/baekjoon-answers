#include <iostream>

using namespace std;

unsigned int a[500001];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N = 0;
    int cnt = 1;

    cin >> N;

    for (int i=0; i<N; i++) {
        cnt++;
        bool isPrimeNumber = true;
        for (int j=0; j<i; j++) {
            if (a[j]*a[j] > cnt) { 
                break;
            }

            if (cnt % a[j] == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        if(!isPrimeNumber)  {
            i--;
        } else {
            a[i] = cnt;
        }
    }

    cout << a[N-1];

    return 0;
}