#include <bits/stdc++.h>
using namespace std;

int n;
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  vector<string> v;
  for(int i=0; i<n; i++){
    string str;
    cin >> str;
    v.push_back(str);
  }

  sort(v.begin(), v.end(), [](const string& a, const string& b){
    int al = a.length();
    int bl = b.length();
    if(al!=bl) return al < bl;
    return a < b;
  });
  v.erase(unique(v.begin(), v.end()), v.end());

  for(string x : v){
    cout << x << "\n";
  }
}