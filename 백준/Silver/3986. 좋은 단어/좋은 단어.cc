#include <iostream>
#include <stack>

using namespace std;

int n;
int main(){
    cin >> n;
    int cnt=0;
    while(n--){
        string str;
        cin >> str;
        stack<char> s;
        for(int i=0; i<str.length(); i++){
            if(s.empty()) s.push(str[i]);
            else{
                if(str[i]==s.top()){
                    s.pop();
                 }
                else s.push(str[i]);
            }
        }
        if(s.empty()) cnt++;
    }
    cout << cnt;
}