#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int n;
    int cnt = 0;

    cin >> n;

    for(int i=0; i<n; i++) {
    	int tmp;
    	cin >> tmp;
    	if(tmp == 1) {
    		cnt++;
    	}
    }

    if((double)n/2 < cnt) {
    	cout << "Junhee is cute!";
    } else {
    	cout << "Junhee is not cute!";
    }

    return 0;
}