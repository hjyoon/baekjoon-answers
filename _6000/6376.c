#include <stdio.h>

int fac(int n) {
	int i = 0;
	int res = 1;

	for(i=1; i<=n; i++) {
		res = res*i;
	}

	return res;
}

int main(void)
{
	int n = 0;
	double e = 0;

	printf("n e\n");
	printf("- -----------\n");

	for(n=0; n<=1; n++) {
		e = e + 1.0/fac(n);
		printf("%d %.0f\n", n, e);
	}

	for(n=2; n<=2; n++) {
		e = e + 1.0/fac(n);
		printf("%d %.1f\n", n, e);
	}

	for(n=3; n<=9; n++) {
		e = e + 1.0/fac(n);
		printf("%d %.9f\n", n, e);
	}

	return 0;
}