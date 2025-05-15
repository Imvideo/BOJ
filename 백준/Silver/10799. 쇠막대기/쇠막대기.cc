#include <iostream>
#include <stack>

using namespace std;

string str;
int ans = 0, num = 0;
stack<char> s;
int main() {
	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		s.push(str[i]);
	}
	while (!s.empty()) {
		char stackTop = s.top();
		s.pop();
		if (stackTop == ')') {
			if (s.top() == ')') num++;
			else {
				ans += num;
				s.pop();
			}
		}
		else { // stackTop == '('
			ans++; num--;
		}
	}
	cout << ans;
}