#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    string s;

    cin >> s;

    transform(s.begin(), s.end(), s.begin(), ::toupper);

	cout << s << '\n';    

    return 0;
}