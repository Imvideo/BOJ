#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int n, m, h;
int board[32][12];
vector<pair<int,int>> ladder;

bool check(){
  for(int i=1; i<=n; i++) {
    int a = 1;
    int b = i;
    while(a <= h) {
      if(board[a][b-1] == 1) b--;
      else if (board[a][b] == 1) b++;
      a++;
    }
    if(b != i) return false;
  }
  return true;
}
int main(){
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  cin >> n >> m >> h;
  for(int i=0; i<m; i++)
  {
    int a, b;
    cin >> a >> b;
    board[a][b] = 1;
  }
  for(int i=1; i<=h; i++) {
    for(int j=1; j<=n; j++) {
      if(board[i][j-1] == 1 || board[i][j] == 1 || board[i][j+1] == 1) continue;
      ladder.push_back({i,j});
    }
  }

  if(check()){
    cout << 0;
    return 0;
  }

  int ans = 4;
  int sz = ladder.size();
  for(int i=0; i<sz; i++){
    board[ladder[i].X][ladder[i].Y] = 1;
    if(check()) ans = min(ans, 1);
    for(int j=i+1; j<sz; j++){
      board[ladder[j].X][ladder[j].Y] = 1;
      if(check()) ans = min(ans, 2);
      for(int k=j+1; k<sz; k++){
        board[ladder[k].X][ladder[k].Y] = 1;
        if(check()) ans = min(ans, 3);
        board[ladder[k].X][ladder[k].Y] = 0;
      }
      board[ladder[j].X][ladder[j].Y] = 0;
    }
  board[ladder[i].X][ladder[i].Y] = 0;
  }
  if(ans == 4) cout << -1;
  else cout << ans;
}

