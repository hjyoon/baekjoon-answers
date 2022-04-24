#include <iostream>
using namespace std;
int main() {
    string s;
    getline(cin, s);

    if(s.compare("Give you up") == 0) {
        cout << "NO";
    } else if(s.compare("Let you down") == 0) {
        cout << "NO";
    } else if(s.compare("Run around and desert you") == 0) {
        cout << "NO";
    } else if(s.compare("Make you cry") == 0) {
        cout << "NO";
    } else if(s.compare("Say goodbye") == 0) {
        cout << "NO";
    } else if(s.compare("Tell a lie and hurt you") == 0) {
        cout << "NO";
    } else {
        cout << "YES";
    }

    return 0;
}