#include <iostream>

using namespace std;

int main()
{
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int n = 0;
	cin >> n;

	for(int i=0; i<n*2; i++) {
		for(int j=0; j<n; j++) {
			if((i+j) % 2 == 0){
				cout << '*';
			}
			else{
				cout << ' ';
			}
		}
		cout << '\n';
	}


	return 0;
}