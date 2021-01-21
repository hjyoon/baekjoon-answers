#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>

using namespace std;

struct Person {
	string name;
	int kor, eng, math;
};

bool cmp(const Person& u, const Person& v) {
	auto tu1 = make_tuple(-u.kor, u.eng, -u.math, u.name);
	auto tu2 = make_tuple(-v.kor, v.eng, -v.math, v.name);

	if(tu1 < tu2) {
		return true;
	} else {
		return false;
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int N;
	cin >> N;

	vector<Person> a;

	for(int i=0; i<N; i++) {
		Person tmp;
		cin >> tmp.name >> tmp.kor >> tmp.eng >> tmp.math;
		a.push_back(tmp);
	}

	sort(a.begin(), a.end(), cmp);

	for(auto x : a) {
		cout << x.name << '\n';
	}

	return 0;
}