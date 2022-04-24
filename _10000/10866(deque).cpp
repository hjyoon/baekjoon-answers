#include <iostream>
#include <deque>

using namespace std;

int main() {
	//cout << "He" << endl;
	freopen("input.txt", "r", stdin);
	int n=0;

	cin >> n;

	deque<int> dq;

	for(int i=0; i<n; i++) {
		string s;
		cin >> s;
		if(s.compare("push_back") == 0) {
			int tmp=0;
			cin >> tmp;
			dq.push_back(tmp);
		} else if(s.compare("push_front") == 0) {
		 	int tmp=0;
			cin >> tmp;
			dq.push_front(tmp);
		} else if(s.compare("pop_front") == 0) {
			if(dq.size() == 0) {
		 		cout << -1 << '\n';
			} else {
				cout << dq.front() << '\n';
				dq.pop_front();
			}
		} else if(s.compare("pop_back") == 0) {
		 	if(dq.size() == 0) {
		 		cout << -1 << '\n';
			} else {
				cout << dq.back() << '\n';
				dq.pop_back();
			}
		} else if(s.compare("size") == 0) {
		 	cout << dq.size() << '\n';
		} else if(s.compare("empty") == 0) {
			cout << dq.empty() << '\n';
		} else if(s.compare("front") == 0) {
			if(dq.size() == 0) {
		 		cout << -1 << '\n';
			} else {
				cout << dq.front() << '\n';
			}
		} else if(s.compare("back") == 0) {
			if(dq.size() == 0) {
		 		cout << -1 << '\n';
			} else {
				cout << dq.back() << '\n';
			}
		}
	}

	return 0;
}