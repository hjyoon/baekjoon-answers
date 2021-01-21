#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N = 0, M = 0;
	cin >> N >> M;
	vector<int> v;
	for(int i=0; i<N; i++) {
		int tmp = 0;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());

	int r = 3;
	vector<int> flag;
	for(int i=0; i<r; i++) {
		flag.push_back(1);
	}
	for(int i=0; i<N-r; i++) {
		flag.push_back(0);
	}
	sort(flag.begin(), flag.end());

	int res = 0;
	do {
		int tmp = 0;
		for(int i=0; i<flag.size(); i++){
			if(flag[i] == 1){
				tmp += v[i];
			}
		}
		if(res < tmp && tmp <= M) {
			res = tmp;
		}
	}while(next_permutation(flag.begin(), flag.end()));

	cout << res;

	return 0;
}