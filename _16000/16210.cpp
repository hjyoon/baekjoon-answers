#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;

int F = 500;

int main() {
	//cin.tie(NULL);
    //ios_base::sync_with_stdio(0);
    //for(int k=1; k<=F; k++) {
    //char input_file_name[128] = "";
    //sprintf(input_file_name, "C:\\Users\\hjyoon\\Desktop\\testcase\\input_data\\input-made%d.txt", 1);
	//freopen(input_file_name, "r", stdin);

	//char output_file_name[128] = "";
	//sprintf(output_file_name, "C:\\Users\\hjyoon\\Desktop\\testcase\\output_data\\output_test.txt", k);
	//freopen(output_file_name, "a", stdout);

	int n = 0;
	cin >> n;

	vector<pair<long long, long long>> v;
	vector<long long> vx;
	vector<long long> vy;

	v.push_back(make_pair(0, 0));
	vx.push_back(0);
	vy.push_back(0);

	for(int i=0; i<n; i++) {
		long long x = 0, y = 0;
		cin >> x >> y;
		vx.push_back(x);
		vy.push_back(y);
		v.push_back(make_pair(x, y));
	}

	sort(vx.begin()+1, vx.end());
	sort(vy.begin()+1, vy.end());

	vector<long long> vpx = vx;
	vector<long long> vpy = vy;

	for(int i = 1; i <= n; i++) {
		vpx[i] = vpx[i-1] + vpx[i];
	}

	for(int i = 1; i <= n; i++) {
		vpy[i] = vpy[i-1] + vpy[i];
	}

	long long res = 0;
	long long min = numeric_limits<long long>::max();
	for(auto i = v.begin()+1; i != v.end(); i++) {
		auto iterX = lower_bound(vx.begin()+1, vx.end(), i->first);
		int idxX = distance(vx.begin(), iterX);
		auto iterY = lower_bound(vy.begin()+1, vy.end(), i->second);
		int idxY = distance(vy.begin(), iterY);

		long long tmp_sum = 0;

		tmp_sum += vpx[n-1] - vpx[idxX] - vpx[idxX-1] - (n-idxX)*(i->first) + (idxX-1)*(i->first);
		tmp_sum += vpy[n-1] - vpy[idxY] - vpy[idxY-1] - (n-idxY)*(i->second) + (idxY-1)*(i->second);


		if(tmp_sum < min) {
			min	= tmp_sum;
			res = distance(v.begin(), i);
			//cout << '(' << i->first << ',' << i->second << ')' << ' ' << res << ' ' << min << '\n';
		}
	}

	cout << res;
	//cout << '\n';
	//}

	return 0;
}