#include <iostream>
#include <queue>
#include <utility>
#define X first
#define Y second

using namespace std;
int n, num1 = 0, num2 = 0;
char board1[102][102]; // !적록색약
char board2[102][102]; // 적록색약
int vis1[102][102]; // !적록색약
int vis2[102][102];	// 적록색약
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
queue<pair<int, int>> q;
int main() {
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board1[i][j];
			if (board1[i][j] == 'G') {
				board2[i][j] = 'R';
			}
			else {
				board2[i][j] = board1[i][j];
			}
		}
		fill(vis1[i], vis1[i] + n, -1);
		fill(vis2[i], vis2[i] + n, -1);
	}
	
	// !적록색약
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (vis1[i][j] != -1) continue;
			q.push({ i,j });
			char color = board1[i][j];
			vis1[i][j] = 0;
			num1++;
			while (!q.empty()) {
				pair<int, int> cur = q.front(); q.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (board1[nx][ny] != color || vis1[nx][ny] != -1) continue;
					vis1[nx][ny] = 0;
					q.push({ nx,ny });
				}
			}
		}
	}

	// 적록색약
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (vis2[i][j] != -1) continue;
			q.push({ i,j });
			char color = board2[i][j];
			vis2[i][j] = 0;
			num2++;
			while (!q.empty()) {
				pair<int, int> cur = q.front(); q.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (board2[nx][ny] != color || vis2[nx][ny] != -1) continue;
					vis2[nx][ny] = 0;
					q.push({ nx,ny });
				}
			}
		}
	}
	cout << num1 << " " << num2;
}