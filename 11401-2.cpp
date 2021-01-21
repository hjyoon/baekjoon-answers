#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9+7;
long long fpow(long long a, int n)
{
    if(n==0)return 1;
    if(n&1){
        return fpow(a,n-1)*a%mod;
    }
    long long half=fpow(a,n>>1);
    return half*half%mod;
}
int main()
{
    int n,k;
    scanf("%d%d",&n,&k);

    k = min(k,n-k);
    //cout << k << '\n';

    long long ans=1;
    long long f=1;

    for(int i=1; i<=k; ++i){
        ans = ans*(n-i+1);
        ans = ans % mod;

        f = f*i;
        f = f % mod;
    }

    long long ie = fpow(f,mod-2);

    cout << ans << '\n';
    cout << f << '\n';
    cout << ie << '\n';

    printf("%lld",ans*ie % mod);
}