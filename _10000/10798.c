#include <stdio.h>

int main(void)
{
	char n[5][16] = {0, };
	int i=0, j=0;

	freopen("input.txt", "r", stdin);

	for(i=0; i<5; i++) {
		scanf("%s", &n[i]);
	}

	for(i=0; i<15; i++) {
		for(j=0; j<5; j++) {
			if(n[j][i] == '\0') {
				continue;
			}else {
				printf("%c", n[j][i]);
			}
		}
	}

	return 0;
}