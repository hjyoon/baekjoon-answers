#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int K = 0, N = 0, M = 0;
 	cin >> K >> N >> M;

 	int need = K * N;

 	int res = need - M;

 	cout << ((res>=0)?(res):(0));

	return 0;
}