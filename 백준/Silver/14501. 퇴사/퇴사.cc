#include <bits/stdc++.h>
using namespace std;

int n;
int arr[17][2];
int d[17];
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=1; i<=n; i++){
    int t, p;
    cin >> t >> p;
    arr[i][0] = t;
    arr[i][1] = p;
  }
  for(int i=n; i>=1; i--){
    if(i+arr[i][0] > n + 1) d[i] = d[i+1];
    else d[i] = max(d[i+1],d[i+arr[i][0]] + arr[i][1]);
  }
  cout << d[1];
  
}