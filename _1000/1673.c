#include <stdio.h>

int main(void)
{
	int n = 0, k = 0;

	freopen("input.txt", "r", stdin);

	while(scanf("%d%d", &n, &k) == 2) {
		int stamp = 0;
		int res = 0;
		while(n) {
			res = res + n;
			stamp += n;
			n = stamp / k;
			stamp -= n*k;
		}
		printf("%d\n", res);
	}

	return 0;
}