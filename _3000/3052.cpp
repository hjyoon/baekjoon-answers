#include <iostream>
#include <set>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    set<int> s;

    for(int i=0; i<10; i++) {
        int tmp = 0;
        cin >> tmp;
        tmp %= 42;
        s.insert(tmp);
    }

    cout << s.size();

    return 0;
}