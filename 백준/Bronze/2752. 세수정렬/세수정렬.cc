#include <bits/stdc++.h>
using namespace std;
int a[4];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> a[0] >> a[1] >> a[2];
  sort(a,a+3);
  for (int i = 0; i < 3; i++) cout << a[i] <<' ';
  return 0;
} 