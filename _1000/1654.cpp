#include <iostream>

using namespace std;

unsigned int a[10000];
int K;
int N;

bool check(unsigned int x) {
    int cnt = 0;
    for (int i=0; i<K; i++) {
        cnt += a[i]/x;
    }
    return cnt >= N;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    

    cin >> K >> N;

    unsigned int max = 0;

    for (int i=0; i<K; i++) {
        cin >> a[i];
        if (max < a[i]) {
            max = a[i];
        }
    }

    unsigned int answer = 0;
    unsigned int left = 1;
    unsigned int right = max;

    while(left <= right) {
        unsigned int mid = (left+right)/2;   
        if (check(mid)) {
            if (answer < mid) {
                answer = mid;
            }
            left = mid+1;
        } else {
            right = mid-1;
        }
    }

    cout << answer;

    return 0;
}