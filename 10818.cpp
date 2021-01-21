#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

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

	auto x = minmax_element(a.begin(), a.end());

	cout << *(x.first) << ' ' << *(x.second) << '\n';


	return 0;
}