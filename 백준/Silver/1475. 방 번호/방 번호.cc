#include <iostream>
#include <vector>
using namespace std;
int main() {
  int num;
  int max = 0;
  vector<int> v1(10);
  cin >> num;
  while(num>0) {
    int x = num % 10;
    if(x == 9) {
      v1[6]++;
    } else {
      v1[x]++;
    }
    num/=10;
  }
  for(int i=0; i<v1.size(); i++){
    if(i==6) {
      if(max < (v1[i]+1)/2) max = (v1[i]+1)/2;
    } else {
      if(max < v1[i]) max = v1[i];
    }
  }
  cout << max;
}