#include <iostream>

using namespace std;

int main() {
	//cout << "Hello World!" << '\n';
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	int n=0;
	cin >> n;
	int* num = new int[n];
	
	for(int i=0; i<n; i++) {
		cin >> num[i];
	}

	int res=0;
	
	if(n == 1) {
	  	res = num[0];
	  	cout << res;
	} else {
		int i;
	 	for(i=0; i<n-1; i++) {
	 		res += (num[i]-1);
	 	}
	 	res += num[i];
		cout << res;
	}
	delete [] num;
	return 0;
}