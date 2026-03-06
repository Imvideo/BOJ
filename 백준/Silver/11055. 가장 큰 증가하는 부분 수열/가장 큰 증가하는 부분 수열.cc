#include <bits/stdc++.h>
using namespace std;

int n, mx;
int arr[100002];
int d[100002][2];
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
  d[1][0] = d[1][1] = mx = arr[1];
  for(int i=2; i<=n; i++){
    d[i][0] = d[i][1] = arr[i];
    int idx = i-1;
    int sumMx = 0;
    while(idx>0){
      if(arr[i] > arr[idx]){
        sumMx = max(sumMx, d[idx][1]);
      }
      idx--;
    }
    d[i][1] += sumMx;
    mx = max(mx, d[i][1]);
  }

  cout << mx;
}