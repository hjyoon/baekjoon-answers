#include <iostream>
#include <string>
#include <set>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string str;
	getline(cin, str);

	int len = str.length();

	set<string> s;
	for(int i=0; i<len; i++) {
		s.insert(str.substr(i,len));
	}

	for(auto x : s) {
		cout << x << '\n';
	}

	return 0;
}