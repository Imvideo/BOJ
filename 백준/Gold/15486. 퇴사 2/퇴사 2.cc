#include <bits/stdc++.h>
using namespace std;

int n;
int t[1500001];
int p[1500001];
int d[1500001];
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=0; i<n; i++){
    cin >> t[i] >> p[i];
  }
  for(int i=n-1; i>=0; i--){
    if(i + t[i] > n) d[i] = d[i+1];
    else d[i] = max(p[i] + d[i+t[i]], d[i+1]);
  }
  cout << d[0];
  
}