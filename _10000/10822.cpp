#include <iostream>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string s;
	int sum=0;
	while(getline(cin, s, ',')) {
		sum += stoi(s);
	}
	cout << sum;

	return 0;
}