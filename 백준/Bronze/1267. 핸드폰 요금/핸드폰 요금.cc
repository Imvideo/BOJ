#include <iostream>
#include <array>
#include <cmath>
using namespace std;

int n,m,Y=0,M=0;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i = 0; i < n;i++){
        cin >> m;
        Y+=(m/30+1)*10;
        M+=(m/60+1)*15;
    }
    if(Y==M) cout << "Y M " << Y;
    else if (Y>M) cout << "M " << M;
    else cout << "Y " << Y;
    return 0;
}