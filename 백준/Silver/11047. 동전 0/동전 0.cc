#include <bits/stdc++.h>
using namespace std;

int n, k;
int coin[12];
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n >> k;
  for(int i=0; i<n; i++){
    int num;
    cin >> num;
    coin[i] = num;
  }
  int cnt = 0, sum = 0;
  for(int i=n-1; i>=0; i--){
    if(sum == k){
      break;
    }
    while(1){
      if(sum + coin[i] > k) break;
      cnt++;
      sum += coin[i];
    }
  }
  cout << cnt;
}