#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int n, m, h;
int board[32][12];
vector<pair<int, int>> coords;

bool check(){
  for(int i=1; i<=n; i++){
    int cur = i;
    for(int j=1; j<=h; j++){
      if(board[j][cur-1]) cur--;
      else if(board[j][cur]) cur++;
    }
    if(cur != i) return 0;
  }
  return 1;
}

int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n >> m >> h;
  for(int i=0; i<m; i++){
    int a, b;
    cin >> a >> b;
    board[a][b] = 1;
  }

  for(int i=1; i<=h; i++){
    for(int j=1; j<n; j++){
      if(board[i][j-1] || board[i][j] || board[i][j+1]) continue;
      coords.push_back({i,j});
    }
  }

  if(check()){
    cout << 0;
    return 0;
  }

  int ans = 4;
  int sz = coords.size();
  for(int i=0; i<sz; i++){
    board[coords[i].X][coords[i].Y] = 1;
    if(check()) ans = min(ans, 1);
    for(int j=i+1; j<sz; j++){
      board[coords[j].X][coords[j].Y] = 1;
      if(check()) ans = min(ans, 2);
      for(int k=j+1; k<sz; k++){
        board[coords[k].X][coords[k].Y] = 1;
        if(check()) ans = min(ans, 3);
        board[coords[k].X][coords[k].Y] = 0;
      }
      board[coords[j].X][coords[j].Y] = 0;
    }
    board[coords[i].X][coords[i].Y] = 0;
  }
  if(ans == 4) ans = -1;
  cout << ans;
  
}
      