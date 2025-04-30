#include <iostream>
#include <list>

using namespace std;

int main() {
  string str,com;
  int n,len=0;
  list<char> list;
  cin >> str >> n;
  cin.ignore();
  for(auto k : str) list.push_back(k);
  auto t = list.end();
  for(int i=0; i<n; i++){
    getline(cin,com);
    if(com[0]=='P'){
      list.insert(t,com[2]);
    } else if (com[0]=='L' && t!=list.begin()){
      t--;
    } else if (com[0]=='D' && t != list.end()){
      t++;
    } else if (com[0]=='B' && t != list.begin()) {
      t--;
      t = list.erase(t);
    }
  }
  for(auto k : list) cout << k;
}