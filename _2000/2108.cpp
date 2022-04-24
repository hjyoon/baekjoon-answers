#include <stdio.h>
#include <malloc.h>

int cnt_p[4001];
int cnt_m[4000];

void swap(int* x, int* y)
{
	int temp = *x;
	*x = *y;
	*y = temp;
}

double avg(int n)
{
	int i=0;
	int sum=0;
	for(i=0; i<4001; i++) {
		sum += (cnt_p[i]*i);
	}
	for(i=0; i<4000; i++) {
		sum -= (cnt_m[i]*(i+1));
	}
	return (double)sum / n;
}

int mid(int n)
{
	int i=0;
	int cnt=0;

	for(i=3999; i>-1; i--) {
		cnt += cnt_m[i];
		if(cnt >= (n/2)+1) {
			return (i+1)*(-1);
		}
	}

	for(i=0; i<4001; i++) {
		cnt += cnt_p[i];
		//printf("i = %d, cnt_p[i] = %d cnt = %d\n", i, cnt_p[i], cnt);
		if(cnt >= (n/2)+1) {
			return i;
		}
	}
	return 0;
}

int mode(int n)
{
	int i=0;
	int tmp=0;
	int sw=0;
	int fir=0;
	int sec=500001;


	for(i=0; i<4001; i++) {
		//printf("i = %d, cnt_p[i] = %d, tmp = %d\n", i, cnt_p[i], tmp);
		if(cnt_p[i] > tmp) {
			//printf("\tcnt_p[i] > tmp\n");
			tmp = cnt_p[i];
			fir = i;
			//printf("\tfir = i  ->  %d\n", fir, i);
			sw = 0;
		} else if(cnt_p[i] == tmp && cnt_p[i] != 0){
			//printf("\tcnt_p[i] == tmp && cnt_p[i] != 0\n");
			if(fir > i) {
				//printf("\t\tfir > i%d\n", i);
				sec = fir;
				fir = i;
				//printf("\t\tsec = fir  ->  %d %d\n", sec, fir);
				//printf("\t\tfir = i  ->  %d\n", i);
			} else if(sec > i) {
				//printf("\t\tsec > i%d\n", i);
				sec = i;
				//printf("\t\tsec = i  ->  %d\n", i);
			}
			sw = 1;
		}
	}

	 for(i=0; i<4000; i++) {
	 	if(cnt_m[i] > tmp) {
	 		tmp = cnt_m[i];
	 		fir = (i+1) * -1;
	 		sw = 0;
	 	} else if(cnt_m[i] == tmp && cnt_m[i] != 0){
	 		if(fir > (i+1) * -1) {
	 			sec = fir;
	 			fir = (i+1) * -1;
	 		} else if(sec > (i+1) * -1) {
	 			sec = (i+1) * -1;
	 		}
	 		sw = 1;
	 	}
	}

	return (sw == 0) ? fir : sec;
}

int rge(int n) {
	int i = 0;
	int maxValue = -4001;
	int minValue = 4001;

	for(i=0; i<4001; i++) {
		int tmp = i;
		if(cnt_p[i] == 0) 
			continue;
		if(tmp > maxValue) 
			maxValue = tmp;
		if(tmp < minValue) 
			minValue = tmp;
	}

	for(i=0; i<4000; i++) {
		int tmp = -(i+1);
		if(cnt_m[i] == 0) 
			continue;
		if(tmp > maxValue) 
			maxValue = tmp;
		if(tmp < minValue) 
			minValue = tmp;
	}

	return maxValue - minValue;
}

int main(void)
{
	int N = 0;
	int i = 0;

	freopen("input.txt", "r", stdin);

	scanf("%d", &N);

	for(i=0; i<N; i++) {
		int tmp = 0;
		scanf("%d", &tmp);
		if(tmp<0)
			cnt_m[(-tmp-1)]++;
		else
			cnt_p[tmp]++;
	}

	// printf("avg = %.6f\n", avg(N));
	// printf("mid = %d\n", mid(N));
	// printf("mode = %d\n", mode(N));
	// printf("range = %d\n", rge(N));

	printf("%.0f\n", avg(N));
	printf("%d\n", mid(N));
	printf("%d\n", mode(N));
	printf("%d\n", rge(N));


	return 0;
}