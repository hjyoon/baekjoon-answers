#include <stdio.h>

int main(void)
{
	int A=0, B=0;
	freopen("input.txt", "r", stdin);
	while(scanf("%d%d", &A, &B)==2) {
		printf("%d\n", A+B);
	}
	return 0;
}