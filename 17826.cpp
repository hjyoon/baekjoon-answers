#include <iostream>
#include <algorithm>

using namespace std;

bool desc(int a, int b) {
	return a > b; // 내림차순
	//return a < b; // 오름차순
}

int main() {
	cin.tie(NULL);
    ios_base::sync_with_stdio(0);
	freopen("input.txt", "r", stdin);

	int arr[50] = {0, };

	for(int i=0; i<50; i++) {
		cin >> arr[i];
	}

	sort(arr, arr+50, desc);

	int target = 0;

	cin >> target;

	int rank = 0;
	
	auto it = find(arr, arr+50, target);
	rank = distance(arr, it);
	rank++;

	if(rank <= 5) {
		cout << "A+";
	}
	else if(rank <= 15) {
		cout << "A0";
	}
	else if(rank <= 30) {
		cout << "B+";
	}
	else if(rank <= 35) {
		cout << "B0";
	}
	else if(rank <= 45) {
		cout << "C+";
	}
	else if(rank <= 48) {
		cout << "C0";
	}
	else {
		cout << "F";
	}


	return 0;
}