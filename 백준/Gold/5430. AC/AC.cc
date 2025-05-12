#include <iostream>
#include <deque>
#include <sstream>
#include <algorithm>

using namespace std;

deque<int> dq;
int t,n,num;
string p;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    while(t--){
        bool flag = false;
        dq.clear();
        string str;
        int cur=0;
        cin >> p >> n >> str;

        for(int i=1; i+1<str.length(); i++){
            if(str[i]==','){
                dq.push_back(cur);
                cur=0;
            }
            else{
                cur = cur * 10 + str[i]-'0';
            }
        }
        if(cur != 0){
            dq.push_back(cur);
        }

        int rev = 0;
        for(int i=0; i<p.length(); i++){
            if(p[i]=='R') {
                rev = 1-rev;
            }
            else{
                if(dq.empty()){
                    flag=true;
                    break;
                }
                else{
                    if(!rev) dq.pop_front();
                    else dq.pop_back();
                }
            }
        }
        if(flag){
            cout << "error\n";
            continue;
        }
        if(rev) reverse(dq.begin(), dq.end());
        cout << "[";
        while(!dq.empty()){
            if(dq.size()==1){
                cout << dq.front();
                break;
            }
            else{
                cout << dq.front() << ",";
                dq.pop_front();
            }
        }
        cout << "]\n";
    }
}