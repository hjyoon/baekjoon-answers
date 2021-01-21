#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    string s;
    getline(cin, s);
    sort(s.begin(), s.end(), greater<int>());
    //reverse(s.begin(), s.end());

    //stringstream ss(s);
    int sum = 0;
    //ss >> num;

    for(auto x : s) {
        sum += (x - '0');
    }

    int tmp = (*(s.rbegin())) - '0';
    bool a = (sum%3 != 0);
    bool b = (tmp != 0);

    if(a || b) {
        cout << -1;
    } else {
        cout << s;
    }

	return 0;
}