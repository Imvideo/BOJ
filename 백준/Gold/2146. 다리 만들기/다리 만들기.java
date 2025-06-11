import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int n, mn = Integer.MAX_VALUE;
    static int[][] map = new int[102][102];
    static int[][] vis = new int[102][102];
    static int[][] isl = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 구분
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && isl[i][j] == 0) {
                    isl[i][j] = cnt++;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    while (!q.isEmpty()) {
                        Point cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (map[nx][ny] != 1 || isl[nx][ny] != 0) continue;
                            isl[nx][ny] = isl[cur.x][cur.y];
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        // 2. 각 섬별로 BFS 한 번만 수행 (모든 섬에서 다른 섬까지의 최단 거리 탐색)
        for (int islandNum = 1; islandNum < cnt; islandNum++) {
            for (int x = 0; x < n; x++) Arrays.fill(vis[x], 0);
            Queue<Point> q = new LinkedList<>();
            // 현재 섬의 모든 칸을 큐에 넣고 vis를 1로 설정
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isl[i][j] == islandNum) {
                        q.add(new Point(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
            boolean found = false;
            while (!q.isEmpty() && !found) {
                Point cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (isl[nx][ny] == islandNum || vis[nx][ny] != 0) continue;
                    vis[nx][ny] = vis[cur.x][cur.y] + 1;
                    if (map[nx][ny] == 1 && isl[nx][ny] != islandNum) {
                        mn = Math.min(mn, vis[cur.x][cur.y] - 1);
                        found = true;
                        break;
                    }
                    q.add(new Point(nx, ny));
                }
            }
        }

        bw.write(mn + "\n");
        bw.flush();
        bw.close();
    }
}
