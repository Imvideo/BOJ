#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for(int i = 0; i <n; i++) {
    for(int j=0;j<n;j++){
      if(j<i) cout <<" ";
      else cout << "*";
    }
    cout <<'\n';
  }
  return 0;
}