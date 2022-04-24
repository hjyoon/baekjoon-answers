#include <stdio.h>

int min(int x, int y) {
    if(x > y) return y;
    else return x;
}

int main(void){
    int k = 0, N = 0;
    int left = 1, right = 0, mid = 0;
    int res = 0;

    freopen("input.txt", "r", stdin);
    scanf("%d%d", &N, &k);
    //right = k;
    right = N*N;

    while(left <= right){
        int cnt = 0;
        int i = 0;

        mid = (left + right) / 2;

        for(i=1; i<=N; i++){
            cnt += min(mid/i, N);
        }
        //printf("left = %d, right = %d, mid = %d, cnt = %d\n", left, right, mid, cnt);

        if(cnt < k){
            left = mid + 1;
        } else{
            res = mid;
            right = mid - 1;
        }
    }

    printf("%d", res);

    return 0;
}