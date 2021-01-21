#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N;
	cin >> N;

	vector<int> a;

	for(int i=0; i<N; i++) {
		int tmp;
		cin >> tmp;
		a.push_back(tmp);
	}

	sort(a.begin(), a.end());

	int max = 0;

	do {
		int tmp = 0;
		for(int i=1; i<N; i++) {
			tmp += (a[i-1]-a[i]) < 0 ? -(a[i-1]-a[i]) : (a[i-1]-a[i]);
		}
		if(tmp > max) 
			max = tmp;
	} while(next_permutation(a.begin(), a.end()));


	cout << max << '\n';

	return 0;
}