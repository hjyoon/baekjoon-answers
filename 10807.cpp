#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string s;
	cin >> s;

	map<char, int> m;

	for(int i=0; i<s.length(); i++) {
		m[s[i]]++;
	}

	for(char i='a'; i<='z'; i++) {
		cout << m[i] << ' ';
	}

	return 0;
}