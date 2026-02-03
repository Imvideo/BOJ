#include <bits/stdc++.h>
using namespace std;

int n, mn = 9999999;
int comb[20];
int board[20][20];
int main(void){
  cin >> n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin >> board[i][j];
    }
  }

  for(int i=n/2; i<n; i++) comb[i] = 1;

  do {
    int teamS = 0, teamL = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(comb[i] == 0 && comb[j] == 0) {
          teamS += board[i][j];
        }
        if(comb[i] == 1 && comb[j] == 1) {
          teamL += board[i][j];
        }
      }
    }
    mn = min(mn, abs(teamS - teamL));
  } while(next_permutation(comb, comb+n));
  cout << mn;
}