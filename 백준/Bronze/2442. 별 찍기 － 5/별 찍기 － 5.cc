#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for(int i = 0; i <n; i++) {
    for(int j=0;j<2*n-1;j++){
      if(j<n-i-1) cout <<" ";
      else if(j>n+i-1) break;
      else cout << "*";
    }
    cout <<'\n';
  }
  return 0;
}