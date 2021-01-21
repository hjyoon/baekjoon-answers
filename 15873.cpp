#include <iostream>
#include <string>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s;
	cin >> s;


	if(s.length() == 2) {
		cout << s[0]-'0' + s[1]-'0';
	}
	else if(s.length() == 4) {
		cout << (s[0]-'0')*10 + (s[2]-'0')*10;
	}
	else if(s.length() == 3) {
		if(s[1] == '0') {
			cout << (s[0]-'0')*10 + (s[2]-'0');
		}
		else if(s[2] == '0'){
			cout << (s[0]-'0') + (s[1]-'0')*10;
		}
	}
	else {
		return 0;
	}


	return 0;
}