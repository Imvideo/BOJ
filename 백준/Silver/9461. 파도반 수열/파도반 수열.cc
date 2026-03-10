#include <bits/stdc++.h>
using namespace std;

int T;
long long d[102];
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> T;
  d[1] = d[2] = d[3] = 1;
  for(int i=4; i<=100; i++){
    d[i] = d[i-2] + d[i-3];
  }
  while(T--){
    int n;
    cin >> n;
    cout << d[n] << "\n";
  }
  
}