#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    vector<string> a;

    for(int i=0; i<8; i++) {
        string tmp;
        getline(cin, tmp);
        a.push_back(tmp);
    }

    int cnt = 0;
    int sw = 0;

    for(auto x : a) {
        for(int i=0; i<8; i++) {
            if(i%2 == 0 && sw == 0) {
                if(x[i] == 'F') {
                    cnt++;
                }
            } else if(i%2 == 1 && sw == 1) {
                if(x[i] == 'F') {
                    cnt++;
                }
            }
        }
        sw = 1 - sw;
    }

    cout << cnt;
    
    return 0;
}