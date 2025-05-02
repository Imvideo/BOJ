#include <iostream>
#include <list>

using namespace std;

int main(){
  int n,k;
  cin >> n >> k;
  list<int> list;
  for(int i=1; i<=n; i++) list.push_back(i);
  auto t = list.begin();
  cout << "<";
  while(!list.empty()){
    for(int i=0; i<k; i++){
      if(i==0) continue;
      if(t != list.end()){
        t++;
        if(t==list.end()) t=list.begin();
      }
    }  
    cout << *t;
    if(list.size() > 1) cout << ", ";
    t = list.erase(t);
    if(t==list.end()) t=list.begin();
  }
  cout << ">";
}