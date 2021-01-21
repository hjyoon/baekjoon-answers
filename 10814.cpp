#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

struct Person {
	string name;
	int age;
};

bool cmp(const Person& u, const Person& v) {
	if(u.age < v.age) {
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
		cin >> tmp.age >> tmp.name;
		a.push_back(tmp);
	}
	
	stable_sort(a.begin(), a.end(), cmp);

	for(auto x : a) {
		cout << x.age << ' ' << x.name << '\n';
	}

	return 0;
}