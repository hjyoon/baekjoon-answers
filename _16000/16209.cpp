#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;

int main()
{
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	vector<int> v1;
	vector<int> v2;
	vector<int> zero;
	for(int i=0; i<n; i++) {
		int tmp = 0;
		cin >> tmp;

		if(tmp < 0) {
			v2.push_back(tmp);
		}
		else if(tmp > 0) {
			v1.push_back(tmp);
		}
		else {
			zero.push_back(tmp);
		}
	}

	sort(v1.rbegin(), v1.rend());
	sort(v2.begin(), v2.end());

	int cnt = 0;
	deque<int> dq1;
	for(auto i : v1) {
		if(v1.size() % 2 == 1) {
			if(cnt % 2 == 0) {
				dq1.push_front(i);
			}
			else {
				dq1.push_back(i);
			}
		}
		else {
			if(cnt % 2 == 0) {
				dq1.push_back(i);
			}
			else {
				dq1.push_front(i);
			}
		}
		cnt++;
	}

	cnt = 0;
	deque<int> dq2;
	for(auto i : v2) {
		if(v2.size() % 2 == 0) {
			if(cnt % 2 == 0) {
				dq2.push_front(i);
			}
			else {
				dq2.push_back(i);
			}
		}
		else {
			if(cnt % 2 == 0) {
				dq2.push_back(i);
			}
			else {
				dq2.push_front(i);
			}
		}
		cnt++;
	}

	for(auto i : dq2) {
		cout << i << ' ';
	}

	for(auto i : zero) {
		cout << i << ' ';
	}

	for(auto i : dq1) {
		cout << i << ' ';
	}

	return 0;
}