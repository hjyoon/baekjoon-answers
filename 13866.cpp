#include <iostream>
#include <cmath>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	int a=0, b=0, c=0, d=0;
	cin >> a >> b >> c >> d;
	
    int res = (a+d)-(b+c);
	cout << abs(res);

	return 0;
}