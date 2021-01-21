#include <cstdio>

int arr[5000000];

int main() {
    //freopen("input.txt", "r", stdin);

    int n = 0;
    int sum = 0;
    int cnt = 0;

    scanf("%d", &n);


    for(int i=0; i<n; i++) {
    	//scanf("%d", &tmp);
    	arr[i] = getchar()-65;
    	sum += arr[i];
    	cnt++;
    }

    printf("%d\n%d", cnt, sum);

	return 0;
}