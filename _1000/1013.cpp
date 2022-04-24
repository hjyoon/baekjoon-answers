#include <iostream>
#include <string>

using namespace std;

int state[2][10] = {
	{1,9,4,1,5,5,1,8,5,9},
	{2,3,9,2,9,6,7,7,3,9}
};

int main()
{
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int T = 0;
	cin >> T;

	while(T--) {
		string str;
		int NOW = 0;
		cin >> str;
		int len = str.length();
		
		for(int i=0;i<len;i++)
			NOW = state[str[i]-'0'][NOW];

		if(NOW==3||NOW==6||NOW==7) {
			cout << "YES" << '\n';
		}
		else {
			cout << "NO" << '\n';
		}
	}


	return 0;
}