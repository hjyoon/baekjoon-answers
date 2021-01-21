// #include <iostream>

// using namespace std;

// void rec1(char ch, int n) {
//     if(n == 0) {
//         return;
//     }
//     else {
//     	printf("%c", ch);
//         return rec1(ch, n-1);
//     }
// }

// int rec2(int n, int m) {
// 	if(m < n) {
//         return 0;
//     }
//     else {
//         return m + rec2(n, m-1);
//     }
// }

// int rec3(int n) {
// 	if(n == 1) {
//         return 0;
//     }
//     else if(n == 2){
//         return 1;
//     } else {
//     	return rec3(n-1) + rec3(n-2);
//     }
// }

// void rec4(int n) {
// 	if(n == 0) {
//         return;
//     }

// 	rec4(n/2);
// 	printf("%d", n%2);
// }

// int main() {
// 	//printf("%d", rec3(7));
// 	rec4(100);

// 	for(int i=n; i>0; i/=2) {

// 	}

// 	return 0;
// }


#include <iostream>
using namespace std;

void solve(int n) {
   if (n < 2) { printf("%d", n); return; }
   solve(n / 2);
   printf("%d", n % 2);
}






















void solve2(int n) {
	if(n/2 == 0) {
		printf("1");
		return;
	}

	solve2(n/2);
	printf("%d", n%2);
}

int fib(int n) {
	static int dp[10000] = {0, };

	if(dp[n]) {
		return dp[n];
	}
	
	if(n == 0) {
		return 0;
	}
	else if(n == 1) {
		return 1;
	}

	return fib(n-1) + fib(n-2);
}

#include <string>
#include <locale>
int main() {
   //int n = 100;
   //int m = 100;

   //int* p = (int*)0xaaaa;
   //printf("%x\n", &n);
   //printf("%x\n", &m);
   //printf("%x\n", p);
   //printf("%p\n", p-(&m+2));
   //printf("%p\n", sizeof(int));

	//solve2(10);

	//setlocale(LC_ALL, "");

	//wstring s = L"Flabébé";
	//wcout << s;

	wprintf(L"Flabébé");

    return 0;
}