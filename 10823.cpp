#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string s;
	string line;
	while(cin >> line) {
		s += line;
	}

	istringstream sin(s);

	string num;
	int sum=0;
	while(getline(sin, num, ',')) {
		sum += stoi(num);
	}
	cout << sum;

	return 0;
}