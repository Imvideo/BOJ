#include <bits/stdc++.h>
using namespace std;
int a,zero,one;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  for (int i=0;i<3;i++){
    zero = 0;
    one = 0;
    for (int j=0;j<4;j++){
      cin >> a;
      if(a == 0) zero++;
      else one++;
    }
    if(zero == 1 && one == 3) cout << "A";
    if(zero == 2 && one == 2) cout << "B";
    if(zero == 3 && one == 1) cout << "C";
    if(zero == 4 && one == 0) cout << "D";
    if(zero == 0 && one == 4) cout << "E";
    cout << "\n";
  }
  return 0;
}