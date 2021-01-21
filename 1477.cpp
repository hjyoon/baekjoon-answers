#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    vector<int> am;
    vector<int> ap;
    int zero = 0;
    int one = 0;

    int N=0;
    cin >> N;

    for(int i=0; i<N; i++) {
        int tmp;
        cin >> tmp;
        if(tmp == 1) {
            one++;
        } else if(tmp > 0) {
            ap.push_back(tmp);
        } else if(tmp < 0) {
            am.push_back(tmp);
        } else {
            zero++;
        }
    }

    sort(am.begin(), am.end());
    sort(ap.begin(), ap.end());
    reverse(ap.begin(), ap.end());

    if (ap.size()%2 == 1) {
        ap.push_back(1);
    }
    if (am.size()%2 == 1) {
        am.push_back(zero > 0 ? 0 : 1);
    }

    int sum = one;

    for (int i=0; i<ap.size(); i+=2) {
        sum += ap[i] * ap[i+1];
    }

    for (int i=0; i<am.size(); i+=2) {
        sum += am[i] * am[i+1];
    }

    cout << sum << '\n';
    
	return 0;
}