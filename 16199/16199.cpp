#include <iostream>

using namespace std;

int main() {
	freopen("../input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int year=0, month=0, day=0;
	int t_year=0, t_month=0, t_day=0;

	cin >> year >> month >> day;
	cin >> t_year >> t_month >> t_day;

	int res = t_year-year;
	if(t_month == month) {
		if(t_day < day) {
			res--;
		}
	}
	else if(t_month < month) {
		res--;
	}

	cout << res << '\n';
	cout << t_year-year+1 << '\n';
	cout << t_year-year;

	return 0;
}