#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int A=0, B=0, V=0;
    cin >> A >> B >> V;

    int res = 0;
    if(V-(A-B) % (A-B) != 0) {
        res = (V-(A-B))/(A-B)+1;
    }
    else {
        res = (V-(A-B))/(A-B);
    }

    cout << res;

    return 0;
}