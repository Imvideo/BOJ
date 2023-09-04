#include <bits/stdc++.h>
using namespace std;
int arr[9],sum=0,cnt=0;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  for(int i = 0; i < 9; i++) {
    cin >> arr[i];
    sum+=arr[i];
  }
  sort(arr,arr+9);
  for(int i=0; i < 8; i++) {    //총 합에서 가짜 난쟁이 2명의 키를 뺄 때 100이면 가짜 난쟁이를 찾을 수 있다
    for(int j=i+1; j < 9; j++) {
      if(sum-arr[i]-arr[j] == 100) {
        arr[i] = arr[j] = 0;    //가짜 난쟁이들의 키를 0으로 바꿈
        cnt=1;
        break;
      }
    }
    if(cnt==1) break;
  }
  sort(arr,arr+9);
  for(int i=2; i < 9; i++) {    //가짜 난쟁이들의 키를 제외한 나머지 출력
    cout << arr[i] << '\n';
  }
  return 0;
}