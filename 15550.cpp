#include <iostream>
using namespace std;
int main() {
    int a = 99999998;
    float b = 99999998;
    int c = 99999999;

    if (a == b) {
        cout << "true" << '\n';
    } else {
        cout << "false" << '\n';
    }
    if (b == c) {
        cout << "true" << '\n';
    } else {
        cout << "false" << '\n';
    }
    if (c != a) {
        cout << "true" << '\n';
    } else {
        cout << "false" << '\n';
    }

    long long tmp1 = 21000000000;
    double tmp2 = tmp1;
    int tmp3 = tmp2;

    cout << tmp1 << '\n';
    cout << tmp2 << '\n';
    cout << tmp3 << '\n';

    if (tmp1 == tmp2) {
        cout << "tmp1 == tmp2" << '\n';
    }

    return 0;
}