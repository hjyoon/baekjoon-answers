#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

union Type {
	unsigned char c[4];
	unsigned int i;
	unsigned short s;
};

int main() {
	freopen("input.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	//wcin.imbue( locale( "korean" ) );
    //wcout.imbue( locale( "korean" ) ); 
 
 	int N = 0;
 	cin >> N;

 	Type data;
 	strcpy((char*)data.c, "°¡");

 	cout << (unsigned int)data.c[0] << ' ' << (unsigned int)data.c[1] << ' ' << (unsigned int)data.c[2] << ' ' << (unsigned int)data.c[3] <<'\n';
 	swap(data.c[0], data.c[1]);
 	//swap(data.c[1], data.c[2]);
 	cout << (unsigned int)data.c[0] << ' ' << (unsigned int)data.c[1] << ' ' << (unsigned int)data.c[2] << ' ' << (unsigned int)data.c[3] <<'\n';

 	data.s += (N-1);

 	cout << (unsigned int)data.c[0] << ' ' << (unsigned int)data.c[1] << ' ' << (unsigned int)data.c[2] << ' ' << (unsigned int)data.c[3] <<'\n';
 	swap(data.c[0], data.c[1]);
 	//swap(data.c[1], data.c[2]);
 	cout << (unsigned int)data.c[0] << ' ' << (unsigned int)data.c[1] << ' ' << (unsigned int)data.c[2] << ' ' << (unsigned int)data.c[3] <<'\n';

 	//cout << data.c << '\n';

 	//data.c[1]+=(N-1);

 	cout << data.c << '\n';

 	//cout << data.i << '\n';
 	//cout << data.s << '\n';

	return 0;
}