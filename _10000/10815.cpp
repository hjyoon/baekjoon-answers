#include <iostream>
#include <map>

using namespace std;

int main() {
	//ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);
	
	int n;
	cin >> n;

	map<int, int> um;

	for(int i=0; i<n; i++) {
		int tmp=0;
		//cin >> tmp;
		scanf("%d", &tmp);
		um[tmp]++;
	}

	int m;
	cin >> m;

	for(int i=0; i<m; i++) {
		int tmp=0;
		//cin >> tmp;
		scanf("%d", &tmp);
		cout << um[tmp] << ' ';

	}

	return 0;
}