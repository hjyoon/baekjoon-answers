#include <iostream>
#include <vector>

using namespace std;

int main() {
	cin.tie(NULL);
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

	int s = v[0], d = 0;
	int max = 0;
	for(int i=1; i<N; i++) {
		if(s < v[i] && d < v[i]) {
			d = v[i];
		}
		else {
			max = max<(d-s)?(d-s):max;
			s = v[i];
			d = v[i];
		}
	}
	
	max = max<(d-s)?(d-s):max;
	cout << max;

	return 0;
}