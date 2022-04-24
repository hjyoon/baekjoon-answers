#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int D = 0, H = 0, M = 0;
 	cin >> D >> H >> M;

 	D -= 11;

 	int criteria = 60*11 + 11;

 	int res = D*24*60 + H*60 + M;

 	cout << ((res-criteria>=0)?(res-criteria):(-1));

	return 0;
}