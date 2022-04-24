#include <iostream>
#include <bitset>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	//freopen("input.txt", "r", stdin);

	bitset<100000> a;
	bitset<100000> b;

	cin >> a >> b;

	cout << (a & b) << '\n';
	cout << (a | b) << '\n';
	cout << (a ^ b) << '\n';
	cout << (~a) << '\n';
	cout << (~b) << '\n';
	
	return 0;
}