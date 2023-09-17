#include <iostream>
#include <array>
#include <cmath>
using namespace std;

int n;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<i;j++) cout << " ";
        for(int j=1;j<=2*(n-i)+1;j++) cout << "*";
        cout<<"\n";
    }
    for (int i=1;i<n;i++){
        for(int j=1;j<n-i;j++) cout << " ";
        for(int j=1;j<=2*(i)+1;j++) cout << "*";
        cout<<"\n";
    }
}