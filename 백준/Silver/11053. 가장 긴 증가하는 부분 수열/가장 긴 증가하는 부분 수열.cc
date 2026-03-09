#include <bits/stdc++.h>
using namespace std;

int n, mx;
int arr[1002];
int d[1002];
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
  d[1] = 1;
  for(int i=2; i<=n; i++){
    int mx = 0;
    for(int j=1; j<i; j++){
      if(arr[i] > arr[j]){
        mx = max(d[j], mx);
      }
    }
    d[i] = mx + 1;
  }

  cout << *max_element(d, d+n+1);
}