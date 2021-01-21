#include <cstdio>
#include <algorithm>

using namespace std;

const int MN = 100 + 1;
int N, M, dp[MN][MN / 2]; // dp[i][j]는 i일까지 j개 쿠폰 가지고 있는 최소 가격 수.
bool chk[MN]; // 쉬는 날인지 확인

int f(int day, int coupon) {
	if (day > N)
		return 0;
	if (dp[day][coupon] == -1)
		dp[day][coupon] = chk[day] ? f(day + 1, coupon) : min({coupon >= 3 ? f(day + 1, coupon - 3) : f(day + 1, coupon) + 10000, f(day + 3, coupon + 1) + 25000, f(day + 5, coupon + 2) + 37000
	});
	return dp[day][coupon];
}

int main() {
	freopen("../input.txt", "r", stdin);
	scanf("%d %d", &N, &M);

	for (int i = 0, get; i < M; ++i) {
		scanf("%d", &get);
		chk[get] = true;
	}

	fill(dp[0], dp[101], -1);

	printf("%d\n", f(1, 0));

	for(int i=0; i<20; i++) {
		for(int j=0; j<20; j++) {
			printf("%2d ", dp[i][j]/1000);
		}
		printf("\n");
	}

	return 0;
}