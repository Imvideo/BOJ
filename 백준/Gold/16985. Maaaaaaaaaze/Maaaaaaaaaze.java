import java.io.*;
import java.util.*;

class Tuple {
    int x, y, z;
    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][][] board = new int[4][5][5][5];
    static int[][][] maze = new int[5][5][5];
    static int[] dx = {1, 0, 0, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 1, -1, 0};

    static int solve() {
        int[][][] dist = new int[5][5][5];
        if (maze[0][0][0] == 0 || maze[4][4][4] == 0) return 9999;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            for (int dir = 0; dir < 6; dir++) {
                int x = tuple.x;
                int y = tuple.y;
                int z = tuple.z;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nz = z + dz[dir];

                if (0 > nx || nx >= 5 || 0 > ny || ny >= 5 || 0 > nz || nz >= 5) continue;
                if (maze[nx][ny][nz] == 0 || dist[nx][ny][nz] != 0) continue;
                if (nx == 4 && ny == 4 && nz == 4) return dist[x][y][z];
                dist[nx][ny][nz] = dist[x][y][z] + 1;
                q.add(new Tuple(nx, ny, nz));
            }
        }
        return 9999;
    }

    static boolean nextPermutation(int[] order) {
        int i = 4;
        while (i > 0 && order[i - 1] >= order[i]) i--;
        if (i == 0) return false;

        int j = 4;
        while (order[i - 1] >= order[j]) j--;

        int temp = order[i - 1];
        order[i - 1] = order[j];
        order[j] = temp;

        j = 4;
        while (i < j) {
            temp = order[i];
            order[i] = order[j];
            order[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    board[0][i][j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[1][i][j][k] = board[0][i][4 - k][j];
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[2][i][j][k] = board[1][i][4 - k][j];
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[3][i][j][k] = board[2][i][4 - k][j];
                }
            }
        }

        int[] order = {0, 1, 2, 3, 4};
        int ans = 9999;

        do {
            for (int tmp = 0; tmp < 1024; tmp++) {
                int brute = tmp;
                for (int i = 0; i < 5; i++) {
                    int dir = brute % 4;
                    brute /= 4;
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            maze[i][j][k] = board[dir][order[i]][j][k];
                        }
                    }
                }
                ans = Math.min(ans, solve());
            }
        } while (nextPermutation(order));

        if (ans == 9999) ans = -1;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
