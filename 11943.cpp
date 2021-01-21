#include <iostream>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int A = 0, B = 0;
	int C = 0, D = 0;
	cin >> A >> B;
	cin >> C >> D;

	cout << ((A+D>B+C)?(B+C):(A+D));

	return 0;
}