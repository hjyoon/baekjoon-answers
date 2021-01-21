#include <iostream>
#include <string>
#include <regex>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	string s;
	getline(cin, s);

	//cout << s << '\n';

	regex word_regex("U.*C.*P.*C.*");

	if(regex_match(s, word_regex)) {
		cout << "I love UCPC" << '\n';
	}
	else {
		cout << "I hate UCPC" << '\n';
	}

	return 0;
}