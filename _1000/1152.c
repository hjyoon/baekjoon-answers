#include <stdio.h>
#include <ctype.h>

int main(void)
{
	char str[1000001] = { 0 };
	int i = 0;
	int cnt = 0;
	int sw = 0;

	freopen("input.txt", "r", stdin);
	gets(str);

	for (i=0; str[i] != '\0'; i++) {
		if (isalpha(str[i]) && sw == 0) {
			cnt++;
			sw = 1;
		} 
		else if(!isalpha(str[i])) {
			sw = 0;
		} 
		else {
			continue;
		}
	}

	printf("%d", cnt);

	return 0;
}