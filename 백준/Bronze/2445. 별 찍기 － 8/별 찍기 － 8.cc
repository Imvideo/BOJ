#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for(int i = 1; i <=n; i++) {
    for(int j=1;j<=2*n;j++){
      if(j<=i || j>=2*n-i+1) cout <<"*";
      else cout << " ";
    }
    cout << "\n";
  }
  for(int i = 1; i <n; i++) {
    for(int j=1;j<=2*n;j++){
      if(j>=n-i+1 && j<=n+i) cout <<" ";
      else cout << "*";
    }
    cout << "\n";
  }
  return 0;
}