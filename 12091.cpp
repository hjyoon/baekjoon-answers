#include <iostream>

using namespace std;

int main() {
	unsigned long long* tmp = new unsigned long long;

	if((unsigned long long)tmp%3 == 0) {
		printf("Jolteon");
	}
	else if((unsigned long long)tmp%3 == 1) {
		printf("Flareon");
	}
	else {
		printf("Vaporeon");
	}

	return 0;
}