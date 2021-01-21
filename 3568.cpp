#include <iostream>
#include <string>
#include <algorithm>
#include <regex>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	regex word_regex("([a-zA-Z]+)([\\*\\[\\]\\&]*)");

	string s;
	getline(cin, s);

	smatch m;

	regex_search(s, m, word_regex);
	string type = m[0];
	s = m.suffix();

	for(int i=0; regex_search(s, m, word_regex); i++) {
		string _type = m[2];
		reverse(_type.begin(), _type.end());

		for(int k=0; k<_type.size(); k++) {
			if(_type[k] == ']') {
				swap(_type[k], _type[k+1]);
				k++;
			}
		}

        cout << type << _type << ' ' << m[1] << ';'<< '\n';
        s = m.suffix();
    }

	return 0;
}