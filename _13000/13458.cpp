#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N = 0;

    cin >> N;

    vector<int> v;

    for(int i=0; i<N; i++) {
        int tmp = 0;
        cin >> tmp;
        v.push_back(tmp);
    }

    int B = 0, C = 0;

    cin >> B >> C;

    long long res = 0;

    for(int i=0; i<N; i++) {
        res++;
        if(v[i] <= B) {
            continue;
        }
        else {
            res += (long long)ceil((v[i]-B)/(double)C);
        }
    }

    cout << res;

    return 0;
}