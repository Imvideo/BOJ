#include <bits/stdc++.h>
using namespace std;
int arr[5],sum=0;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  for (int i = 0; i < 5; i++) {
    cin >> arr[i];
    sum+=arr[i];
  }
  sort(arr,arr+5);
  cout << sum/5 << '\n' << arr[2];
  return 0;
}