#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <deque>
#include <algorithm>

using namespace std;

void parsing(string& s, deque<int>& dq) {
    string tmp;
    for (auto iter = s.begin(); iter < s.end(); iter++) {
        if (*iter >= '0' && *iter <= '9') {
            tmp.push_back(*iter);
        }
        else if (*iter == ',') {
            tmp.push_back(' ');
        }
        else {
            continue;
        }
    }

    // for(auto iter=tmp.begin(); iter<tmp.end(); iter++) {
    //     cout << *iter << '\n';
    // }
    char* c_tmp = (char*)malloc(tmp.size() + 1);
    memset(c_tmp, 0, tmp.size() + 1);
    strcpy(c_tmp, tmp.c_str());
    char* token = strtok(c_tmp, " ");
    while (token != NULL) {
        dq.push_back(stoi(token));
        token = strtok(NULL, " ");
    }
    free(c_tmp);

    // for (auto iter = dq.begin(); iter < dq.end(); iter++) {
    //     cout << *iter << '\n';
    // }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;
    cin >> T;

    while (T--) {
        string p;
        cin >> p;

        int n = 0;
        cin >> n;

        string raw_data;
        cin >> raw_data;

        deque<int> dq;
        parsing(raw_data, dq);

        bool sw = false;
        bool error = false;

        for (auto s : p) {
            if (s == 'R') {
                sw = !sw;
            }
            else if (s == 'D') {
                if (sw == false && !dq.empty()) {
                    dq.pop_front();
                }
                else if (sw == true && !dq.empty()) {
                    dq.pop_back();
                }
                else {
                    cout << "error\n";
                    error = true;
                    break;
                }
            }
        }

        if (error) {
            continue;
        }

        cout << '[';
        if (sw == false && !dq.empty()) {
            auto a = dq.begin();
            for (; a < dq.end() - 1; a++) {
                cout << *a << ',';
            }
            cout << *a;
        }
        else if (sw == true && !dq.empty()) {
            auto a = dq.rbegin();
            for (; a < dq.rend() - 1; a++) {
                cout << *a << ',';
            }
            cout << *a;
        }
        cout << ']';
        cout << '\n';

    }

    return 0;
}