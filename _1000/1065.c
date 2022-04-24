#include <stdio.h>

int check(int n[]) {
	if (n[1] - n[0] == n[2] - n[1]) {
		return 1;
	}
	else {
		return 0;
	}
}

int res(int n) {
	int tmp = 100;
	int a[3] = { 0 };
	int i = 0;
	while (n != 0) {
		a[i] = n / tmp;
		n -= a[i] * tmp;
		tmp /= 10;
		i++;
	}
	return check(a);
}

int main(void)
{
	int i = 0;
	int cnt = 99;
	int in = 0;

	freopen("input.txt", "r", stdin);
	scanf("%d", &in);

	if (in < 99) {
		printf("%d", in);
		return 0;
	}

	for (i = 101; i<=in; i++) {
		if (i == 1000) {
			continue;
		}
		if (res(i)) {
			cnt++;
		}
	}

	printf("%d", cnt);

	return 0;
}