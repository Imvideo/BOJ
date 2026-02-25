#include <bits/stdc++.h>
using namespace std;

int arr[1000002];
int T, n;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> T;
  arr[1] = 1;
  arr[2] = 2;
  arr[3] = 4;
  for(int i=4; i <= 10; i++){
    arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
  }
  while(T--){
    cin >> n;
    cout << arr[n] << "\n";
  }
  
}