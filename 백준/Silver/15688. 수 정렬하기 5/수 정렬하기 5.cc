#include <bits/stdc++.h>
using namespace std;

int n;
int freq[2000002];
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  while(n--){
    int num;
    cin >> num;
    freq[num+1000000]++;
  }
  for(int i=0; i<=2000000; i++){
    if(!freq[i]) continue;
    int cnt = freq[i];
    while(cnt--){
      cout << i-1000000 << "\n";
    }
  }
}