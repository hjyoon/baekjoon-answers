#include <iostream>
using namespace std;
int main() {
	int N=0;
	cin >> N;
	for(int i=0; i<N; i++) {
		int V=0, E=0, res=0;
		cin >> V >> E;
		res = 2+E-V;
		cout << res << '\n';
	}
	return 0;
}