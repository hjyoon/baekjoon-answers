#include <iostream>
#include <string>
#include <regex>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	regex word_regex("(100+1+|01)+");

	for(int i=0; i<n; i++) {
		string s;
		//getline(cin, s);
		cin >> s;

		if(regex_match(s, word_regex)) {
			cout << "YES" << '\n';
		}
		else {
			cout << "NO" << '\n';
		}
	}

	return 0;
}