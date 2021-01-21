#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int check_num(string s[], int sx, int sy) {
    int res1 = 0;
    bool stat = false;
    // W로 시작
    for(int i=sy; i<sy+8; i++) {
        for(int j=sx; j<sx+8; j++) {
            if(stat == false) {
                if(s[i][j] == 'W') {
                } else if(s[i][j] == 'B') {
                    res1++;
                }
                stat = true;
            } else if(stat == true) {
                if(s[i][j] == 'W') {
                    res1++;
                } else if(s[i][j] == 'B') {
                }
                stat = false;
            }
        }
        stat = !stat;
    }

    int res2 = 0;
    stat = true;
    // B로 시작
    for(int i=sy; i<sy+8; i++) {
        for(int j=sx; j<sx+8; j++) {
            if(stat == false) {
                if(s[i][j] == 'W') {
                } else if(s[i][j] == 'B') {
                    res2++;
                }
                stat = true;
            } else if(stat == true) {
                if(s[i][j] == 'W') {
                    res2++;
                } else if(s[i][j] == 'B') {
                }
                stat = false;
            }
        }
        stat = !stat;
    }

    return (res1<res2)?res1:res2;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0, M=0;

    cin >> N >> M;
    cin.get();

    string map[N];
    for(int i=0; i<N; i++) {
        getline(cin, map[i]);
    }
    
    unsigned int min = ~0;
    for(int i=0; i<N-8+1; i++) {
        for(int j=0; j<M-8+1; j++) {
            unsigned int tmp = check_num(map, j, i);
            if(min > tmp) {
                min = tmp;
            }
        }
    }
    cout << min;

    return 0;
}