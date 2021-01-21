#include <iostream>
#include <sstream>
#include <string>

using namespace std;

void solve(string s) {
    for (int i=(int)s.size()-2; i>=0; i--) {
        if (s[i] == ']') cout << "[]", i--;
        else if (s[i] == '&' || s[i] == '*') cout << s[i];
        else {
            cout << ' ';
            for (int j=0; j<=i; j++) cout << s[j];
            cout << ";\n";
            return;
        }
    }
}

int main() {
    freopen("input.txt", "r", stdin);

    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(0);

    string input;
    getline(cin, input);
    stringstream ss(input);
    string datatype, variable;
    ss >> datatype;
    while (ss >> variable) { 
        cout << datatype;
        solve(variable);
    }
    return 0;
}