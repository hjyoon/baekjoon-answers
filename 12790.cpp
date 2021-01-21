#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    int T = 0;

    cin >> T;

    while(T--) {
        int hp=0, mp=0, atk=0, def=0;
        int n_hp=0, n_mp=0, n_atk=0, n_def=0;

        cin >> hp >> mp >> atk >> def >> n_hp >> n_mp >> n_atk >> n_def;

        hp += n_hp;
        mp += n_mp;
        atk += n_atk;
        def += n_def;

        if(hp < 1) {
            hp = 1;
        }

        if(mp < 1) {
            mp = 1;
        }

        if(atk < 0) {
            atk = 0;
        }

        int res = hp + 5*mp + 2*atk + 2*def;
        cout << res << '\n';
    }

    return 0;
}