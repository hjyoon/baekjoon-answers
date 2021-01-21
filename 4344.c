#include <stdio.h>

int main(void)
{
	int C = 0;
	int i = 0, j = 0;
	double res[1000] = { 0, };

	freopen("input.txt", "r", stdin);
	scanf("%d", &C);
	for (i = 0; i<C; i++) {
		int N = 0;
		int arrScore[1000] = { 0, };
		double avg = 0;
		int tmp = 0;

		scanf("%d", &N);

		for (j = 0; j<N; j++) {
			scanf("%d", &arrScore[j]);
			avg += arrScore[j];
		}

		avg /= N;

		for (j = 0; j<N; j++) {
			if (arrScore[j]>avg)
				res[i]++;
		}

		res[i] = res[i] / N * 100;
	}

	for (i = 0; i < C; i++) {
		printf("%.3lf%%\n", res[i]);
	}

	return 0;
}