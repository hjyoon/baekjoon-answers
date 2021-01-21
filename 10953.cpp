#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int T;
	cin >> T;
	int n, m;
	for(int i=1; i<=T; i++) {
		cin >> n >> m;
        cout << "Case #" << i << ": " << n << " + " << m << " = "<< n+m << '\n';
    }

	return 0;
}