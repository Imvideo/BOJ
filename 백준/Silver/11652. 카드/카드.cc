#include <bits/stdc++.h>
using namespace std;

int n;
long long arr[100002];
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=0; i<n; i++){
    cin >> arr[i];
  }
  sort(arr, arr+n);
  int idx = 0, cnt = 1, mxCnt = 0;
  for(int i=0; i<n-1; i++){
    if(arr[i] == arr[i+1]){
      cnt++;
      if(mxCnt < cnt){
        idx = i;
        mxCnt = cnt;
      }
    }
    else{
      cnt=1;
    }
  }
  cout << arr[idx];
}