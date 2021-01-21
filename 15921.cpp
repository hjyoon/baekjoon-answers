#include <iostream>
#include <vector>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;

	for(int i=0; i<n; i++) {
		int tmp = 0;
		cin >> tmp;
		v.push_back(tmp);
	}

	double avg = 0;
	for(int i=0; i<n; i++) {
		avg += v[i];
	}
	avg /= n;

	if(n == 0) {
		cout << "divide by zero";
		return 0;
	}

	double under = 0;
	for(int i=0; i<n; i++) {
		under = under + (v[i] * (1.0/n));
	}

	cout.precision(2);
	cout << fixed << avg/under;


	return 0;
}