#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	while(1) {
		vector<int> v;
		for(int i=0; i<3; i++) {
			int tmp = 0;
			cin >> tmp;
			v.push_back(tmp);
		}
		sort(v.begin(), v.end());

		if(v[0] + v[1] + v[2] == 0) {
			break;
		}
		if(v[0]*v[0] + v[1]*v[1] == v[2]*v[2]) {
			cout << "right" << endl;
		}
		else {
			cout << "wrong" << endl;
		}
	}

	return 0;
}