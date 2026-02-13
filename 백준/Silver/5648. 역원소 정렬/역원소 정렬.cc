#include <bits/stdc++.h>
using namespace std;

int n;
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  vector<string> v;
  for(int i=0; i<n; i++){
    string num;
    cin >> num;
    v.push_back(num);
  }

  for(int i=0; i<n; i++){
    string num = v[i];
    string tmp = "";
    bool flag = false;
    for(int j=num.length()-1; j>=0; j--){
      if(!flag && num[j] != '0'){
        flag = true;
        tmp += num[j];
      } 
      else if(flag){
        tmp += num[j];
      }
    }
    v[i] = tmp;
  }

  for(int i=0; i<n; i++){
    for(int j=0; j<n-1; j++){
      if(v[j].length() > v[j+1].length()){
        swap(v[j],v[j+1]);
      } else if(v[j].length() == v[j+1].length()){
        if(v[j] > v[j+1]) swap(v[j], v[j+1]);
      }
    }
  }


  for(string x : v){
    cout << x << "\n";
  }


}