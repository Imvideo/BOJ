#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> gitar;
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin >> n;
  for(int i=0; i<n; i++){
    string line;
    cin >> line;
    gitar.push_back(line);
  }
  sort(gitar.begin(), gitar.end());

  for(int i=0; i<gitar.size(); i++){
    for(int j=0; j<gitar.size()-i-1; j++){
      if(gitar[j].length() > gitar[j+1].length()) swap(gitar[j],gitar[j+1]);
      else if(gitar[j].length() == gitar[j+1].length()){
        int sumA = 0, sumB = 0;
        for(int k=0; k<gitar[j].length(); k++){
          if(gitar[j][k] - '0' > 0 && gitar[j][k] - '0' < 10) sumA += gitar[j][k] - '0';
          if(gitar[j+1][k] - '0' > 0 && gitar[j+1][k] - '0' < 10) sumB += gitar[j+1][k] - '0';
        }
        if(sumA>sumB) swap(gitar[j],gitar[j+1]);
        else if(sumA == sumB){
          if(gitar[j]>gitar[j+1]) swap(gitar[j], gitar[j+1]);
        }
      }
    }
  }

  for(string s : gitar){
    cout << s << '\n';
  }
}