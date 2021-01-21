#include <iostream>

using namespace std;

int main() {
	int a=0, b=0, c=0, d=0;
	
	for(a=2; a<=100; a++) {
		for(b=2; b<=a; b++) {
			for(c=b; c<=a; c++) {
				for(d=c; d<=a; d++) {
					if(a*a*a == b*b*b + c*c*c + d*d*d) {
						cout << "Cube = " << a << ", " << "Triple = " << '(' << b << ',' << c << ',' << d << ')' << '\n';
					}
				}
			}
		}
	}

	return 0;
}