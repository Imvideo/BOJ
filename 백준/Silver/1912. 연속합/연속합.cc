#include <bits/stdc++.h>
using namespace std;

int n;
int arr[100002];
int d[100002];
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=1; i<=n; i++){
    int num;
    cin >> num;
    arr[i] = num;
  }
  d[1] = arr[1];
  int mx = d[1];
  for(int i=2; i<=n; i++){
    if(d[i-1] < 0 && d[i-1] < arr[i]) {
      d[i] = arr[i];
    }
    else{
      d[i] = d[i-1] + arr[i];
    }
    mx = max(mx, d[i]);
  }

  cout << mx;
}