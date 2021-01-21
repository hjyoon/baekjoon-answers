#include <iostream>

using namespace std;

int a[10000];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N = 0, M = 0;

    cin >> N >> M;

    for(int i=0; i<M; i++) {
        cin >> a[i];
    }

    if (N <= M) {
        cout << N;
        return 0;
    }

    long long left = 0;
    long long right = 2000000000LL * 1000000LL;
    while (left <= right) {
        long long mid = (left + right) / 2;
        long long begin, end;
        begin = end = 0;
        end = M;
        for (int i=0; i<M; i++) {
            end += mid/a[i];
        }

        begin = end;
        for (int i=0; i<M; i++) {
            if (mid % a[i] == 0) {
                begin -= 1;
            }
        }

        begin += 1;
        if (N < begin) {
            right = mid-1;
        } else if (N > end) {
            left = mid+1;
        } else {
            for (int i=0; i<M; i++) {
                if (mid % a[i] == 0) {
                    if (N == begin) {
                        cout << i+1;
                        return 0;
                    }
                    begin += 1;
                }
            }
        }
    }

    return 0;
}