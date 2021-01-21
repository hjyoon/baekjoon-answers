#include <stdio.h>

int main(void)
{
	int n1=0, n2=0, n3=0, n4=0;

	freopen("input.txt", "r", stdin);

	while(scanf("%d%d%d%d", &n1, &n2, &n3, &n4) == 4) {
		int ans = 0;
		ans = n1+n2+n3+n4;
		switch(ans) {
			case 4:
				printf("E\n");
				break;
			case 3:
				printf("A\n");
				break;
			case 2:
				printf("B\n");
				break;
			case 1:
				printf("C\n");
				break;
			case 0:
				printf("D\n");
				break;
		}
	}

	return 0;
}