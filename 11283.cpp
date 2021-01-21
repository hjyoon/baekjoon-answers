#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	uint32_t code;
	char str[10];
	scanf("%s",str);
	code = ((uint32_t)(str[0]&15u)<< 12) + ((uint32_t)(str[1]&63u)<<6) + (uint32_t)(str[2]&63u);
	code -= 0xAC00;
	printf("%d\n", (int)code + 1);

	return 0;
}