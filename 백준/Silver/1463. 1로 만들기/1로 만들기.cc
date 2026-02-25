#include <bits/stdc++.h>
using namespace std;

int arr[1000002];
int n;

void func(int k){
  
}
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=2; i<1000001; i++){
    int a, b, c;
    a = b = c = 1000002;
    if(i % 3 == 0) a = arr[i/3] + 1;
    if(i % 2 == 0) b = arr[i/2] + 1;
    c = arr[i-1] + 1;
    arr[i] = min(min(a, b), c);
  }
  cout << arr[n];
}