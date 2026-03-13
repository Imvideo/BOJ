#include <bits/stdc++.h>
using namespace std;

long long d[101][10];
const int mod = 1000000000;
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  int n;
  cin >> n;
  for(int i=1; i<=9; i++){
    d[1][i] = 1;
  }

  for(int i=2; i<=n; i++){
    for(int j=0; j<10; j++){
      if(j != 0) d[i][j] += d[i-1][j-1];
      if(j != 9) d[i][j] += d[i-1][j+1];
      d[i][j] %= mod;
    }
  }
  long long sum = 0;
  for(int i=0; i<10; i++){
    sum += d[n][i];
  }
  cout << sum % mod;
}
      