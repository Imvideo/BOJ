import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m;
        int num = 0;
        int ans = 2000;
        String line;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<Point>();
        String[][] map = new String[n][m];
        int[][] check = new int[n][m];
        int[][] fire = new int[n][m];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean flag = false;

        // 지도 입력
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            String[] lines = line.split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = lines[j];
            }
        }

        // 거리 확인용 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], -1);
            Arrays.fill(fire[i], -1);
        }

        // 불 지도 미리 큐에 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("F")) {
                    queue.add(new Point(i, j));
                    fire[i][j] = 0;
                }
            }
        }

        // 불 지도 큐 돌리기
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            num = fire[point.x][point.y] + 1;
            for (int dir = 0; dir < 4; dir++) {
                int nx = point.x + dx[dir];
                int ny = point.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue; // 맵 범위 나간 경우
                if (fire[nx][ny] != -1 || map[nx][ny].equals("#"))
                    continue;
                fire[nx][ny] = num;
                queue.add(new Point(nx, ny));
            }
        }

        // 지훈이 큐 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("J")) {
                    queue.add(new Point(i, j));
                    check[i][j] = 0;
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        bw.write(1 + "");
                        bw.flush();
                        bw.close();
                        System.exit(0);
                    }
                }
            }
        }

        // 지훈이 지도 큐 돌리기
        while (!queue.isEmpty()) {
            if (flag)
                break;
            Point point = queue.poll();
            num = check[point.x][point.y] + 1;
            for (int dir = 0; dir < 4; dir++) {
                int nx = point.x + dx[dir];
                int ny = point.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue; // 맵 범위 나간 경우
                if (check[nx][ny] != -1 || map[nx][ny].equals("#"))
                    continue;
                if (fire[nx][ny] != -1 && num >= fire[nx][ny])
                    continue;
                check[nx][ny] = num;
                if (nx == 0 || nx == n - 1 || ny == 0 || ny == m - 1) {
                    ans = num + 1;
                    flag = true;
                    break;
                }
                queue.add(new Point(nx, ny));
            }
        }

        if (!flag)
            bw.write("IMPOSSIBLE");
        else
            bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}
