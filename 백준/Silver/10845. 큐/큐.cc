#include <iostream>
#include <queue>

using namespace std;
int n;
int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  queue<int> q;
  while(n--){
    string word;
    cin >> word;
    if(word == "push"){
      int num;
      cin >> num;
      q.push(num);
    }
    else if(word == "pop"){
      if(q.empty()) cout << -1;
      else{
        cout << q.front();
        q.pop();
      }
      cout << "\n";
    }
    else if(word == "size") cout << q.size() << "\n";
    else if(word == "empty"){
      if(q.empty()) cout << 1;
      else cout << 0;
      cout << "\n";
    }
    else if(word == "front"){
      if(q.empty()) cout << -1;
      else cout << q.front();
      cout << "\n";
    }
    else{
      if(q.empty()) cout << -1;
      else cout << q.back();
      cout << "\n";
    }
  }
}