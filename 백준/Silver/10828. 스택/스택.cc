#include <iostream>
#include <stack>

using namespace std;

int main(){
  int n;
  cin >> n;
  stack<int> s;
  while(n--){
    string com;
    cin >> com;
    if(com=="push"){
      int num;
      cin >> num;
      s.push(num);
    } else if(com=="pop"){
      if(s.empty()) cout << -1 << "\n";
      else {
        cout << s.top() << "\n";
        s.pop();
      }
    } else if(com=="size"){
      cout << s.size() << "\n";
    } else if(com=="empty"){
      if(s.empty()) cout << 1 << "\n";
      else cout << 0 << "\n";
    } else{
      if(s.empty()) cout << -1 << "\n";
      else cout << s.top() << "\n";
    }
  }
}