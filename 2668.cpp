#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);

    int a[10] = {0, };
    bool result;

    int (*x)[10] = &a;
	int *y = &a[0];


 
	if ((void *)x == (void *)y)
    	result = (sizeof(*x) == sizeof(*y));

    printf("%d\n", sizeof(*x));
    printf("%d\n", sizeof(*y));
    printf("%d\n", result);



	return 0;
}