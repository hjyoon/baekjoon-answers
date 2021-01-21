#include <stdio.h>

int main(void)
{
    int x=0;
    int five = 0, three = 0;
	int cnt = 99999;    // 엄청 큰 수를 초기값으로 둔다
    
    scanf("%d", &x);
    three = x / 3;
    
    while (1) {
		if(five*5 + three*3 > x) {
			// 5와3 조합의 합이 x 보다 클 경우
			if(three == 0) {
				// 더 이상 뺄 3이 없을 경우
				if (cnt == 99999) {
					printf("%d\n", -1);
                    return 0;
				}
				break;
			} else {
				three--;
			}
		} else if (five * 5 + three * 3 < x) {
			// 5와3 조합의 합이 x 보다 작을 경우
			five++;
		} else {
			// 합이 x와 동일 할 경우
			if (five + three < cnt) {
				// 이전 조합의 갯수보다 작을 경우 정보 업데이트
				cnt = five + three;
			} if (three == 0) {
				break;
			} else {
				three--;
			}
		}
    }

	printf("%d", cnt);
	
    return 0;
}