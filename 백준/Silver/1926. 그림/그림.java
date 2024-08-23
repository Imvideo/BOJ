import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m;
        int mx = 0;
        int num = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] check = new int[n][m];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || check[i][j] == 1) {
                    continue;
                }
                num++;
                check[i][j] = 1;
                int area = 0;
                Queue<Point> queue = new LinkedList<Point>();
                queue.add(new Point(i, j));
                while (!queue.isEmpty()) {
                    area++;
                    Point point = queue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = point.x + dx[dir];
                        int ny = point.y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                            continue;
                        if (check[nx][ny] == 1 || map[nx][ny] != 1)
                            continue;
                        check[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
                mx = Math.max(mx, area);
            }
        }
        bw.write(num + "\n" + mx);
        bw.flush();
        bw.close();
    }
}
