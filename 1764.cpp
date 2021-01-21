#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N, M;
	cin >> N >> M;

	map<string, int> d;

	for(int i=0; i<N; i++) {
		string s;
		cin >> s;
		d[s]++;
	}

	for(int i=0; i<M; i++) {
		string s;
		cin >> s;
		d[s]++;
	}

	int res = 0;

	for(auto p : d) {
		if(p.second == 2) {
			res++;
		}
	}

	cout << res << '\n';

	for (auto p : d) {
        if (p.second == 2) {
            cout << p.first << '\n';
        }
    }

	return 0;
}