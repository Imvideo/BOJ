#include <bits/stdc++.h>

using namespace std;

int n,x,cnt;
int arr[1000002];
int arr2[2000002];

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=1; i<=n; i++) cin >> arr[i];
  cin >> x;
  for(int i=1; i<=n; i++){
    if(x > arr[i] && arr2[x-arr[i]]==1) {
      cnt++;
    }
    arr2[arr[i]] = 1;
  }
  cout << cnt;
}