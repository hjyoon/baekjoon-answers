#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);
	
	int n, m;
	do {
		cin >> n >> m;
		if(n ==0 && m == 0) break;
        else cout << n+m << '\n';
    } while(true);

	return 0;
}