#include <iostream>
#include <list>
#include <string>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	string s;
	cin >> s;

	list<char> l(s.begin(), s.end());
	auto cursor = l.end();

	int n;
	cin >> n;

	for(int i=0; i<n; i++) {
		char tmp;
		cin >> tmp;

		if(tmp == 'L') {
			if (cursor != l.begin()) {
                cursor--;
            }
		} else if(tmp == 'D') {
			if (cursor != l.end()) {
                cursor++;
            }
		} else if(tmp == 'B') {
			if(cursor != l.begin()) {
				auto tmp = cursor;
				cursor--;
				l.erase(cursor);
				cursor = tmp;
			}
		} else if(tmp == 'P') {
			char tmp;
			cin >> tmp;
			l.insert(cursor, tmp);
		}
	}

	for(char c : l) {
		cout << c;
	}

	cout << '\n';

	return 0;
}