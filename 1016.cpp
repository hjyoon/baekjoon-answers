#include <iostream>

using namespace std;

bool res[1000002];

int main() {
    long long min = 0, max = 0;
    cin >> min >> max;

    for(long long i=2; i*i<=max; i++) {
        for(long long j=min%(i*i)!=0?(min/(i*i))+1:(min/(i*i)); j*i*i<=max; j++) {
            res[j*i*i-(min-1)] = true;
        }
    }


    long long cnt = 0;
    for(long long i=1; i<=(max-min+1); i++) {
        if(res[i] == false) {
            cnt++;
        }
    }

    cout << cnt;

    return 0;
}