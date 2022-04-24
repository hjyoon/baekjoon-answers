#include <iostream>
#include <string>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N = 0;

    cin >> N;

    int i = 0;
    int j = 0;
    int cnt = 0;
    for(i=0; i<N; i++) {
        cnt = 0;
        string s;
        cin >> s;
        //cout << s << '\n';
        //cout << s.size() << '\n';
        for(j=0; j<s.size(); j++) {
            cnt++;
            if(j<s.size() && s[j] != s[j+1]) {
                cout << cnt << ' ' << s[j] << ' ';
                cnt = 0;
            }
        }
        cout << '\n';
    }

    return 0;
}