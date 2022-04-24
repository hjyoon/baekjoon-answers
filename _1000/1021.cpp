#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <deque>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N=0, M=0;
    cin >> N >> M;

    deque<int> dq;
    vector<int> target;

    for(int i=0; i<M; i++) {
    	int tmp=0;
    	cin >> tmp;
    	target.push_back(tmp);
    }

    for(int i=1; i<=N; i++) {
        dq.push_back(i);
    }

    int res=0;
    while(1) {
    	if(target.empty()) {
    		break;
    	}

    	int n=0;

    	int t = target.front();
    	target.erase(target.begin());

    	cout << t << '\n';

    	int size = dq.size();

    	auto iter = find(dq.begin(), dq.end(), t);
    	int d = distance(dq.begin(), iter);

    	bool s;
    	if(size-d > d) {
    		n = d;
    		s = true;
    	} else if(size-d <= d){
    		n = size-d;
    		s = false;
    	}
    	//cout << size << '\n';
    	//cout << d << '\n';
    	//cout << n;

    	for(int i=0; i<n; i++) {
    		if(s == true) {
    			dq.push_back(dq.front());
    			cout << "<<" << '\n';
    		} else if(s == false) {
    			dq.push_front(dq.back());
    			cout << ">>" << '\n';
    		}
    	}

    	dq.pop_front();
    	res += n;
    }

    cout << res;

    return 0;
}