#include <iostream>
#include <stack>

using namespace std;

long long a[100000];

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    while (1) {
	    int n = 0;
	    cin >> n;

        if (n == 0) {
        	break;
        }

	    for (int i=0; i<n; i++) {
	        cin >> a[i];
    	}

	    stack<long long> s;
	    long long ans = 0;

	    for (int i=0; i<n; i++) {
	        int left = i;
	        while(!s.empty() && a[s.top()] > a[i]) {
	            long long height = a[s.top()];
	            cout << s.top() << ' ' << i << '\n';
	            s.pop();
	            long long width = i;
	            if (!s.empty()) {
	                width = (i - s.top() - 1);
	            }
	            if (ans < width*height) {
	                ans = width*height;
	            }
	        }
	        s.push(i);
	    }

	    while(!s.empty()) {
	        long long height = a[s.top()];
	        cout << s.top() << ' ' << n << '\n';
	        s.pop();
	        long long width = n;
	        if (!s.empty()) {
	            width = n-s.top()-1;
	        }
	        if (ans < width*height) {
	            ans = width*height;
	        }
	    }
	         
	    cout << ans << '\n';
    }

    return 0;
}