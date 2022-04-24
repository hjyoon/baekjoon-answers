#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int n = 0;

    cin >> n;

    int a = 0;
    int b = 0;

    for(int i=0; i<n; i++) {
    	char tmp = 0;
    	cin >> tmp;
    	if(tmp == 'A') {
    		a++;
    	} else {
    		b++;
    	}
    }

    if(a > b) {
    	cout << 'A';
    } else if(a < b) {
    	cout << 'B';
    } else {
    	cout << "Tie";
    }

    return 0;
}