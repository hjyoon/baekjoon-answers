#include <iostream>

using namespace std;

void convert(int num, int base) {
    if (num == 0) 
        return;

    convert(num/base, base);

    cout << num % base << ' ';
}

int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int A, B;
    cin >> A >> B;
    int m;
    cin >> m;

    int ans = 0;
    for(int i=0; i<m; i++) {
        int n;
        cin >> n;
        ans = ans * A + n;
    }

    convert(ans, B);

    return 0;
}