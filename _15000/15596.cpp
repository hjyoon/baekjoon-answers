#include <iostream>
#include <vector>

using namespace std;

long long sum(vector<int> &a) {
	long long ans = 0;
    int len = a.size();
	for(int i=0; i<len; i++) {
		ans += a[i];
	}
	return ans;
}

int main() {
	vector<int> a = {1,2,3,4,5};
	cout << sum(a) << endl;
	return 0;
}