#include <bits/stdc++.h>
using namespace std;
int arr1[22];
int arr2[22];
int a,b;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  for (int i=1;i<=20;i++) {
    arr1[i] = i;
  }
  for(int i=0;i<10;i++) {
    cin >> a >> b;
    copy(arr1+1,arr1+21,arr2+1);
    for(int j=a;j<=b;j++) {
      arr1[j] = arr2[b-(j-a)];
    }
  }
  for (int i=1;i<=20;i++) cout << arr1[i] <<' ';
  return 0;
}