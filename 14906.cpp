#include <iostream>
#include <string>
#include <algorithm>
#include <regex>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	//regex word_regex("(((D|E)F+)+G)");
	//regex word_regex("((AH)|(A((((D|E)F+)+G))+C)|(AB()+C))");
	//regex word_regex("(AB)+C");
	regex word_regex("{([^{}]*+(?:(?R)[^{}]*)*+)}");
	string s;
	getline(cin, s);

	smatch m;


	if(regex_match(s, m, word_regex)) {
		cout << "OK" << '\n';
		cout << m[0] << '\n';
	}
	else {
		cout << "ERROR" << '\n';
	}

	// regex_search(s, m, word_regex);
	// string type = m[0];
	// s = m.suffix();

	// for(int i=0; regex_search(s, m, word_regex); i++) {
	// 	string _type = m[2];
	// 	reverse(_type.begin(), _type.end());

	// 	for(int k=0; k<_type.size(); k++) {
	// 		if(_type[k] == ']') {
	// 			swap(_type[k], _type[k+1]);
	// 			k++;
	// 		}
	// 	}

 //        cout << type << _type << ' ' << m[1] << ';'<< '\n';
 //        s = m.suffix();
 //    }

	return 0;
}