#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    string s;
    cin >> s;

    vector<int> num;
    vector<int> sign;

    bool minus = false;
    int cur = 0;

    sign.push_back(1);
    for (int i=0; i<s.size(); i++) {
        if (s[i] == '+' || s[i] == '-') {
            if (s[i] == '+') {
                sign.push_back(1);
            } else {
                sign.push_back(-1);
            }
            num.push_back(cur);
            cur=0;
        } else {
            cur = cur * 10 + (s[i] - '0');
        }
    }
    num.push_back(cur);

    int ans = 0;
    minus = false;
    for (int i=0; i<num.size(); i++) {
        if (sign[i] == -1) {
            minus = true;
        }
        if (minus) {    // 마이너스 뒤에 나오는 모든 양수를 음수로 바꿔준다
            ans -= num[i];
        } else {
            ans += num[i];
        }
    }

    cout << ans << '\n';

    return 0;
}