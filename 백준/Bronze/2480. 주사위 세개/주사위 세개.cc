#include <bits/stdc++.h>
using namespace std;

int a,b,c;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> a >> b >> c;
  if ( a == b && b == c && a == c) cout << 10000+a*1000;
  else if (a != b && b!= c && a !=c){
    cout << max({a,b,c}) * 100;
  }
  else {
    if (a == b) cout << 1000 + a*100;
    else if (a == c) cout << 1000 + a*100;
    else if (b == c) cout << 1000 + b*100;
  }
  return 0;
}