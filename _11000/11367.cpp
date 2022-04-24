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

    int T = 0;
    cin >> T;
    cin.get();

    while(T--) {
        string name;
        int score = 0;

        cin >> name >> score;

        if(score >= 97) {
            cout << name << " A+\n";
        } else if(score >= 90) {
            cout << name << " A\n";
        } else if(score >= 87) {
            cout << name << " B+\n";
        } else if(score >= 80) {
            cout << name << " B\n";
        } else if(score >= 77) {
            cout << name << " C+\n";
        } else if(score >= 70) {
            cout << name << " C\n";
        } else if(score >= 67) {
            cout << name << " D+\n";
        } else if(score >= 60) {
            cout << name << " D\n";
        } else {
            cout << name << " F\n";
        }
    }

    return 0;
}