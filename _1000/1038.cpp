#include <iostream>

using namespace std;

long long arr[1000001];
int cnt;

int check(long long a) {
    long long tmp1 = 0;
    long long tmp2 = 0;

    if(a <= 10) {
        return 0;
    }
    
    while(1) {
        tmp1 = a%10;
        a = a/10;
        if(a == 0) {
            break;
        }

        tmp2 = a%10;
        if(tmp1 < tmp2) {
            continue;
        } else {
            return -1;
        }
    }

    return 0;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);

    int N = 0;

    cin >> N;

    if(N > 1022) {
        cout << -1;
        return 0;
    }

    long long i=0;
    while(1) {
        if(check(i) == 0) {
            arr[cnt] = i;
            if(cnt == N) {
                cout << arr[cnt];
                return 0;
            } else {
                cnt++;
            }
        } else {
            i++;
        }
    }



    // for(long long i=0; i<=9876543210ll; i++) {
    //     if(check(i) == 0) {
    //         arr[cnt] = i;
    //         //cout << "arr[" << cnt << "] = " << i << '\n';
    //         if(cnt == N) {
    //             cout << arr[cnt];
    //             return 0;
    //         } else {
    //             cnt++;
    //         }
    //     } else {
    //         arr[cnt] = -1;
    //         if(cnt == N) {
    //             cout << arr[cnt];
    //             return 0;
    //         }
    //     }
    // }

    return 0;
}