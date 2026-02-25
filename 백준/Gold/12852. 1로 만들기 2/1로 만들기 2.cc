#include <bits/stdc++.h>
using namespace std;

int n;
int d[1000002];
int pre[1000002];

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=2; i<=n; i++){
    int a, b, c;
    a = b = c = 1000002;
    a = d[i-1] + 1;
    if(i % 2 == 0) b = d[i/2] + 1;
    if(i % 3 == 0) c = d[i/3] + 1;
    d[i] = min({a, b, c});
    if(min({a, b, c}) == a) {
      pre[i] = i-1;
    }
    else if(min({a, b, c}) == b){
      pre[i] = i/2;
    }
    else pre[i] = i/3;
  }
  cout << d[n] << "\n" << n << " ";

  while(1){
    if(n == 1) break;
    cout << pre[n] << " ";
    n = pre[n];
  }
}