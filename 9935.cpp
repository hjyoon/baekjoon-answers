#include <iostream>
#include <vector>
#include <string>

using namespace std;

int f_check(vector<char>& v, string& B, int len) {
	int v_size = v.size();
	for (int i = 0; i < len; i++) {
		if (v[v_size - 1 - i] == B[len-1-i]) {
			continue;
		}
		else {
			return -1;
		}
	}
	return 0;
}

int r_check(vector<char>& v, string& B, int len) {
	int v_size = v.size();
	for (int i = 0; i < len; i++) {
		if (v[v_size - 1 - i] == B[i]) {
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

	string A, B;
	cin >> A >> B;

	vector<char> f;
	vector<char> r;


	int a_len = A.size();
	int b_len = B.size();
	int i = 0;

	while(1) {
		if (i >= a_len) {
			break;
		}
		f.push_back(A[i]);
		i++;
		if (f.size() >= b_len && f_check(f, B, b_len) == 0) {
			for (int i = 0; i < b_len; i++) {
				f.pop_back();
			}
		}
	}

	while(1) {
		while(1) {
			if(r.size() >= b_len && r_check(r, B, b_len) == 0) {
				for(int i=0; i<r.size(); i++) {
					r.pop_back();
				}
			}

			if(f.empty() == false) {
				r.push_back(f.back());
				f.pop_back();
			}
			else {
				break;
			}
		}

		while(1) {
			if(f.size() >= b_len && f_check(f, B, b_len) == 0) {
				for(int i=0; i<f.size(); i++) {
					f.pop_back();
				}
			}

			if(r.empty() == false) {
				f.push_back(r.back());
				r.pop_back();
			}
			else {
				break;
			}
		}
	}

	if (f.size() == 0 && r.size() == 0) {
		cout << "FRULA";
	}

	for (int i = 0; i < f.size(); i++) {
		cout << f[i];
	}

	return 0;
}