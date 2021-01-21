#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int ans=0;
	string str;
	cin >> str;

	stack<int> stk;
	int len = str.length();
	for(int i=0; i<len; i++) {
		if(str[i] == '(') {
			stk.push(i);
		} else if(str[i] == ')' && i - stk.top() == 1) {
			stk.pop();
			ans += stk.size();
		} else if(str[i] == ')' && i - stk.top() != 1) {
			stk.pop();
			ans++;
		}
    }

    cout << ans;

	return 0;
}