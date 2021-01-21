#include <bits/stdc++.h>
using namespace std;
#define REP(i, a, b) for(int i=(a);i<=(b);i++)
#define PB push_back
#define CT continue
#define elif else if
#define F first
#define S second
#define MP make_pair
#define INF 2147483647
#define lINF 9223372036854775807
#define PRM 1000000007
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pi;





void solve(){
    string s1, s2;
    cin >> s1;
    cin >> s2;
    int l1=s1.length(), l2=s2.length();
    vector<int> zv(l1+1);
    vector<vector<int>> v(l2+1, zv);
    REP(i, 1, l2){
        REP(j, 1, l1){
            if(s1[j-1]==s2[i-1]){
                v[i][j]=v[i-1][j-1]+1;
            }
            //if(s1[j-1]==s2[i-1] && v[i][j-1]==v[i-1][j]){
            //    v[i][j]=v[i][j-1]+1;
            //}
            else v[i][j]=max(v[i][j-1], v[i-1][j]);
        }
    }

    cout << v[l2][l1];
    return;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    int t=1;
    //cin >> t;
    while(t--){
        solve();
    }
    return 0;
}