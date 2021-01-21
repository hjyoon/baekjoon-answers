#include <iostream>
#include <vector>
#include <string>

using namespace std;

int f_check(vector<char>& v, string& A) {
	for (int i = 0; i < A.size(); i++) {
		if (v[v.size() - 1 - i] == A[A.size() - 1 - i]) {
			continue;
		}
		else {
			return -1;
		}
	}
	return 0;
}

int r_check(vector<char>& v, string& A) {
	for (int i = 0; i < A.size(); i++) {
		if (v[v.size() - 1 - i] == A[i]) {
			continue;
		}
		else {
			return -1;
		}
	}
	return 0;
}

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	string A, T;
	cin >> A >> T;

	vector<char> f;
	vector<char> r;

	int i = 0, j = T.size() - 1;
	while (i <= j) {
		while (i <= j) {
			f.push_back(T[i]);
			i++;
			if (f.size() >= A.size() && f_check(f, A) == 0) {
				for (int i = 0; i < A.size(); i++) {
					f.pop_back();
				}
				break;
			}
		}

		while (i <= j) {
			r.push_back(T[j]);
			j--;
			if (r.size() >= A.size() && r_check(r, A) == 0) {
				for (int i = 0; i < A.size(); i++) {
					r.pop_back();
				}
				break;
			}
		}
	}

	while (1) {
		if (r.size() >= A.size()) {
			if (r_check(r, A) == 0) {
				for (int i = 0; i < A.size(); i++) {
					r.pop_back();
				}
			}
		}
		if (f.empty() == false) {
			r.push_back(f.back());
			f.pop_back();
		}
		else {
			break;
		}
	}

	for (int i = r.size()-1; i >= 0; i--) {
		cout << r[i];
	}

	return 0;
}