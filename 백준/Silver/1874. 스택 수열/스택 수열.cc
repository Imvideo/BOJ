#include <bits/stdc++.h>
using namespace std;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  stack<int> s;
  vector<char> ans;
  int n,num,s_num=0,flag =0;
  cin>>n;
  s.push(s_num);
  s_num++;
  for (int i=0; i<n; i++){
    cin >> num;
    if (num > s.top()){
        if (num < s_num){
        flag = 1;
        break;
      }
      int cnt = num-s_num+1;
      for (int j=0; j<cnt; j++){
        s.push(s_num);
        s_num++;
        ans.push_back('+');
      }
      s.pop();
      ans.push_back('-');
    }
    else if (num < s.top()){
      while(num != s.top()){
        if (num > s.top()) {
          flag = 1;
          break;
          }
        s.pop();
        ans.push_back('-');
        if (num == s.top()){
          ans.push_back('-');
          s.pop();
          break;
        }
      }
    }
    else{
      s.pop();
      ans.push_back('-');
    }
    if (flag == 1) break;
  }
  if(flag == 1) cout << "NO";
  else {
    for (int i=0; i<ans.size(); i++){
      cout << ans[i] <<"\n"; 
    }
  }
}