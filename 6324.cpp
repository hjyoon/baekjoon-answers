#include <iostream>
#include <string>
#include <regex>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	regex word_regex("(http|ftp|gopher)://([^/:]+):?([0-9]*)/?(.*)");


	for(int i=0; i<n; i++) {
		string s;
		//getline(cin, s);
		cin >> s;

		smatch m;
		cout << "URL #" << i+1 << '\n';
		if(regex_match(s, m, word_regex)) {
			cout << "Protocol = " << m[1] << '\n';
			cout << "Host     = " << m[2] << '\n';

			if(m[3].compare("") == 0) {
				cout << "Port     = " << "<default>" << '\n';
			}
			else {
				cout << "Port     = " << m[3] << '\n';
			}
			if(m[4].compare("") == 0) {
				cout << "Path     = " << "<default>" << '\n';
			}
			else {
				cout << "Path     = " << m[4] << '\n';
			}
			cout << '\n';
		}
	}

	return 0;
}