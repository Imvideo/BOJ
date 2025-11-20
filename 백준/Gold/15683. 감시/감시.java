import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, camNum = 0, cnt, zero = 0, mn;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] board = new int[10][10];
    static int[][] tmp = new int[10][10];
    static ArrayList<Point> cam = new ArrayList<>();

    static void func(int x, int y, int dir) {
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || tmp[nx][ny] == 6)
                break;
            if (tmp[nx][ny] == 0) {
                tmp[nx][ny] = 7;
                cnt++;
            }
            x = nx;
            y = ny;
        }
    }

    public static void main(String args[]) throws IOException {
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6)
                    cam.add(new Point(i, j));
                if (board[i][j] == 0)
                    zero++;
            }
        }
        mn = zero;
        //
        for (int i = 0; i < (1 << (2 * cam.size())); i++) {
            int k = i;
            cnt = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    tmp[x][y] = board[x][y];
                }
            }
            for (int j = 0; j < cam.size(); j++) {
                int r, c, num;
                int dir = k % 4;
                k /= 4;
                r = cam.get(j).x;
                c = cam.get(j).y;
                num = board[r][c];
                if (num == 1) {
                    func(r, c, dir);
                } else if (num == 2) {
                    func(r, c, dir);
                    func(r, c, (dir + 2) % 4);
                } else if (num == 3) {
                    func(r, c, dir);
                    func(r, c, (dir + 1) % 4);
                } else if (num == 4) {
                    func(r, c, dir);
                    func(r, c, (dir + 1) % 4);
                    func(r, c, (dir + 2) % 4);
                } else if (num == 5) {
                    func(r, c, dir);
                    func(r, c, (dir + 1) % 4);
                    func(r, c, (dir + 2) % 4);
                    func(r, c, (dir + 3) % 4);
                }

            }
            int area = zero - cnt;
            mn = Math.min(mn, area);
        }
        bw.write(mn + "");
        bw.flush();
        bw.close();
    }
}