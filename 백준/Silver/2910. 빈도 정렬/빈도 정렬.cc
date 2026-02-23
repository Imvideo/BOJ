#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int n, c;

bool cmp(const pair<int, int> &a, const pair<int, int> &b){
  return a.Y > b.Y;
}
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n >> c;
  vector<pair<int,int>> v; // <num, cnt>
  for(int i=0; i<n; i++){
    int num;
    cin >> num;
    bool flag = false;
    for(pair<int,int> &x : v){
      if(x.X == num) {
        x.Y++;
        flag = true;
        break;
      }
    }
    if(!flag) {
      v.push_back({num, 1});
    }
  }

  stable_sort(v.begin(), v.end(), cmp);
  for(auto b : v){
    while(b.Y--) cout << b.X << " ";
  } 
}