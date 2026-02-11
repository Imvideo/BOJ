#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[1000002];
int b[1000002];
int ans[2000004];
int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> m;
  for(int i=0; i<n; i++){
    cin >> a[i];
  }
  for(int i=0; i<m; i++){
    cin >> b[i];
  }

  int idxA = 0, idxB = 0;
  for(int k=0; k<n+m; k++){
    if(idxA == n) {
      ans[k] = b[idxB++];
      continue;
    }
    else if(idxB == m) {
      ans[k] = a[idxA++];
      continue;
    }
    if(a[idxA] <= b[idxB]) {
      ans[k] = a[idxA++];
    }
    else{
      ans[k] = b[idxB++];
    }
  }
  for(int i=0; i<n+m; i++){
    cout << ans[i] << " ";
  }
}

