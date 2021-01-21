#include <iostream>

using namespace std;

void swap(int* a, int* b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

void sort(int a[], int size) {
    for(int i=0; i<size; i++) {
        for(int j=1; j<size-i; j++) {
            if(a[j-1] > a[j]) {
                swap(a[j-1], a[j]);
            }
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int a[5] = {0, };

    for(int i=0; i<5; i++) {
        cin >> a[i];
    }

    sort(a, 5);  

    int avg = 0;
    for(int i=0; i<5; i++) {
        avg += a[i];
    }    
    avg /= 5;

    cout << avg << '\n';
    cout << a[2];

    return 0;
}