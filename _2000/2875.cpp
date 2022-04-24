#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    //cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N, M, K;
    cin >> N >> M >> K;

    while(K) {
        if(2*M > N) {
            M--;
            K--;
        } else if(2*M < N) {
            N--;
            K--;
        } else {
            M--;
            K--;
        }
    }

    if(2*M > N) {
        cout << N/2;
    } else {
        cout << M;
    }
    
	return 0;
}