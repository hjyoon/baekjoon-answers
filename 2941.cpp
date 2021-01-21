#include <stdio.h>

int check(char str[], const char* ch[], int i, int j) {
	if (str[i] == ch[j][0]) {
		int tmp = 1;
		while (1) {
			if (ch[j][tmp] == '\0') {
				return (tmp-1);
			}
			else if (str[i + tmp] == ch[j][tmp]) {
				tmp++;
				continue;
			}
			else {
				return 0;
			}
		}
	}

	return 0;
}

int main(void) {
	char str[101] = { 0 };
	const char* ch[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
	int cnt = 0;

	scanf("%s", str);

	for (int i=0; str[i]!='\0'; i++) {
		for (int j=0; j<8; j++) {
			int tmp = 0;
			if (tmp = check(str, ch, i, j)) {
				i += tmp;
				break;
			}
		}
		cnt++;
	}

	printf("%d", cnt);

	return 0;
}