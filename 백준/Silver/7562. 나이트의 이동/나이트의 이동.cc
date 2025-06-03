#include <iostream>
#include <queue>
#include <utility>

using namespace std;
bool flag;
int T, l, n, m, x, y;
int board[302][302];
int dx[8] = { 2, 1, -1, -2, -2, -1, 1, 2 };
int dy[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };

int main() {
	cin >> T;
	while (T--) {
		cin >> l >> n >> m >> x >> y;
		for (int i = 0; i < l; i++) {
			fill(board[i], board[i] + l, -1);
		}
		flag = false;
		queue <pair<int, int>> q;
		board[n][m] = 0;
		q.push({ n,m });
		if (n == x && m == y) {
			cout << board[n][m] << "\n";
			continue;
		}
		while (!q.empty()) {
			if (flag) break;
			auto cur = q.front(); q.pop();
			for (int dir = 0; dir < 8; dir++) {
				int nx = cur.first + dx[dir];
				int ny = cur.second + dy[dir];
				if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
				if (board[nx][ny] > -1) continue;
				board[nx][ny] = board[cur.first][cur.second] + 1;
				q.push({ nx,ny });
				if (nx == x && ny == y) {
					flag = true;
					cout << board[nx][ny] << "\n";
					break;
				}
			}
		}

	}
}