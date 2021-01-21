#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int p1=0, s1=0;
	int s2=0, p2=0;
	cin >> p1 >> s1;
	cin >> s2 >> p2;

	if(p1+p2 > s1+s2) {
		cout << "Persepolis";
	}
	else if(p1+p2 < s1+s2) {
		cout << "Esteghlal";
	}
	else {
		if(p2 > s1) {
			cout << "Persepolis";
		}
		else if(p2 < s1) {
			cout << "Esteghlal";
		}
		else {
			cout << "Penalty";
		}
	}

	return 0;
}