#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int N = 0;

    cin >> N;

    int cnt = 0;

    for(int i=0; i<5; i++) {
    	int tmp = 0;
    	cin >> tmp;

    	if(N == tmp) {
    		cnt++;
    	}
    }

    cout << cnt;

    return 0;
}