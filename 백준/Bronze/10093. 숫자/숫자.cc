#include <iostream>
#include <array>
#include <cmath>
using namespace std;

int a,b;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> a >> b;
    
    if(a>b) swap(a,b);
    if (a==b) cout << 0 << '\n';
    else cout << b-a-1 << '\n';
    while(1){
        if (a==b) break;
        if(a+1 == b) break;
        cout << a+1 << ' ';
        a++;
    }
    return 0;
}