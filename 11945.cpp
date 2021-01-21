#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

	int N=0, M=0;
	cin >> N >> M;
	string s[N];

	for(int i=0; i<N; i++) {
		//getline(cin, s[i]);
		cin >> s[i];
	}


	for(int i=0; i<N; i++) {
		reverse(s[i].begin(), s[i].end());
		cout << s[i] << '\n';
	}

	return 0;
}