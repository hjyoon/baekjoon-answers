#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    while(1) {
        bool stat = true;
        string s;
        getline(cin, s);

        if(s == ".") {
            break;
        }

        stack<char> st;
        int l = s.length();
        for(int i=0; i<l; i++) {
            if(s[i] == '(' || s[i] == '[') {
                st.push(s[i]);
            } else if(s[i] == ')') {
                if(st.empty()) {
                    stat = false;
                    break;
                } else {
                    if('(' == st.top()) {
                        st.pop();
                    } else {
                        stat = false;
                        break;
                    }
                }
            } else if(s[i] == ']') {
                if(st.empty()) {
                    stat = false;
                    break;
                } else {
                    if('[' == st.top()) {
                        st.pop();
                    } else {
                        stat = false;
                        break;
                    }
                }
            } else {
                continue;
            }
        }

        if(stat == true && st.empty()) {
            cout << "yes\n";
        } else {
            cout << "no\n";
        }
    }

    return 0;
}