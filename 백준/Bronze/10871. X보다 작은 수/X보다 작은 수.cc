#include <iostream>
#include <array>
#include <cmath>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A[10002] = {0, };
    int X,N;
    cin >> N >> X;
    for (int i = 0; i <N; i++) {
        cin >> A[i];
        if (A[i]<X) cout << A[i] <<" ";
    }
    
    return 0;
}