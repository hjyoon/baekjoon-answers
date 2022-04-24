#include <iostream>

using namespace std;

int main() {
	int X = 0;

	cin >> X;

	switch(X) {
		case 1:	// 홀수 (TV인치)
		cout << 65;
		break;
		case 2:	// 홀수 (포스터)
		cout << 17;
		break;
		case 3: // 짝수 (iPad개수)
		cout << 4;
		break;
		case 4: // 짝수 (모니터개수)
		cout << 4;
		break;
		case 5: // 짝수 (ram)
		cout << 64;
		break;
	}

	return 0;
}