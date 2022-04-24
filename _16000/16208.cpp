#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	vector<int> v;
	unsigned long long sum = 0;
	for(int i=0; i<n; i++) {
		int tmp = 0;
		cin >> tmp;
		sum += tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());

	unsigned long long res = 0;

	for(auto i : v) {
		//cout << i << '\n';
		res += (sum-i)*i;
		sum -= i;
	}

	cout << res;


	return 0;
}