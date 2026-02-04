#include <bits/stdc++.h>
using namespace std;

int n, l, ans = 0;
int board[102][102];

bool check(vector<int>& line){
  int idx = 0;
  int cnt = 1;
  while(idx < n-1){
    if(abs(line[idx] - line[idx+1]) > 1) return 0;
    if(line[idx] == line[idx+1]) {
      cnt++; idx++;
    } else if(line[idx] < line[idx+1]){
      if(cnt < l) return 0;
      cnt = 1; idx++;
    } else{
      if(idx+l >= n) return 0;
      for(int i = idx + 1; i<idx + l; i++){
        if(line[i] != line[i+1]) return 0;
      }
      cnt = 0; idx += l;
    }
  }
  return 1;
}
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> l;
  for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
      cin >> board[i][j];

  for(int i=0; i<n; i++){ // 가로 줄 계산
    vector<int> line;
    for(int j=0; j<n; j++) line.push_back(board[i][j]);
    ans += check(line);
  }

  for(int i=0; i<n; i++){ // 세로 줄 계산
    vector<int> line;
    for(int j=0; j<n; j++) line.push_back(board[j][i]);
    ans += check(line);
  }
  cout << ans;
}
      