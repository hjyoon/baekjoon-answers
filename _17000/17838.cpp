#include <iostream>
#include <string>
#include <regex>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int T = 0;
	cin >> T;

	regex word_regex;

	try {
        word_regex = "([A-Z]){2}(?!\\1)([A-Z]){2}\\1\\2{2}";
    }
    catch(const regex_error& e) {
        
        cout << "regex_error caught: " << e.what() << endl;
    }

	smatch m;

	while(T--) {
		string s;
		cin >> s;
		if(regex_match(s, m, word_regex)) {
			cout << '1' << '\n';
		}
		else {
			cout << '0' << '\n';
		}
	}
	
	return 0;
}