#include <iostream>

using namespace std;

int main() {
	int H = 0, M = 0;
	cin >> H >> M;


	int t = H*60 + M;
	t = (1440+t-45)%1440;

	int HH = t/60;
	int MM = t%60;

	//(60+M-45)%60;

	cout << HH << ' ' << MM;

	return 0;
}