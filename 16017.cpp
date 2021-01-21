#include <iostream>
#include <vector>

using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n1=0, n2=0, n3=0, n4=0;
	cin >> n1 >> n2 >> n3 >> n4;
	
	if((n1 == 9 || n1 == 8) && (n4 == 9 || n4 == 8) && (n2 == n3)) {
		cout << "ignore";
	}
	else {
		cout << "answer";
	}


	return 0;
}