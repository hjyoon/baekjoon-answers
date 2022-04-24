#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
 	int a = 0, b = 0, c = 0, d = 0, P = 0;
 	cin >> a >> b >> c >> d >> P;

 	int X = a * P;
 	int Y = b + ((P>c)?(d*(P-c)):(0));

 	//cout << b << '\n';
 	//cout << c << ' ' << P << '\n';
 	//cout << X << ' ' << Y << '\n';
 	cout << (X<Y?X:Y);

	return 0;
}