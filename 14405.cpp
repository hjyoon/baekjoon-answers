#include <iostream>
#include <string>
#include <regex>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	string s;
	cin >> s;

	cout << s << '\n';

	regex word_regex("(pi|ka|chu)*");

	if(regex_match(s, word_regex)) {
		cout << "YES" << '\n';
	}
	else {
		cout << "NO" << '\n';
	}

	return 0;
}