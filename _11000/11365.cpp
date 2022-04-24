#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);


    while(1) {
    	string s;
    	getline(cin, s);

    	if(s == "END") {
    		break;
    	}

    	for(auto it = s.rbegin();  it!=s.rend(); ++it) {
    		cout << *it;
    	}
    	cout << '\n';
    }

    return 0;
}