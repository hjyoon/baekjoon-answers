#include <iostream>

using namespace std;

int main() {
	unsigned long long* tmp = new unsigned long long;
	
	printf("%s", ((unsigned long long)tmp%5 != 0 ? "Yonsei" :"Korea"));

	return 0;
}