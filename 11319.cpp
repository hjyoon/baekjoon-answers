#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

bool check(char c) {
    string s = "AEIOUaeiou";

    int l = s.length();
    for(int i=0; i<l; i++) {
        if(c == s[i]) {
            return true;
        }
    }
    return false;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;
    cin.get();

    while(T--) {
        string s;
        //cin.clear();
        //cin.ignore();

        //cin >> s;
        getline(cin, s);
        //cout << s;
        //cout << '\n';

        int vowel=0, consonant=0;
        int l = s.length();
        for(int i=0; i<l; i++) {
            if(check(s[i])) {
                vowel++;
            } else if(s[i] == ' ') {
                continue;
            } else {
                consonant++;
            }
        }
        
        cout << consonant << ' ' << vowel << '\n';
    }

    return 0;
}