import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, L, R, num = 1, day = 0;
    static int[][] board = new int[52][52];
    static int[][] union;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String args[]) throws IOException {
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            boolean flag = false;
            // 국경선 확인
            visited = new boolean[52][52];
            union = new int[52][52];
            num = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (union[i][j] != 0) continue;
                    union[i][j] = num++;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Point cur = q.poll();
                        for(int d=0; d<4; d++){
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                            int diff = Math.abs(board[cur.x][cur.y] - board[nx][ny]);
                            if (L > diff || diff > R) continue;
                            union[nx][ny] = union[cur.x][cur.y];
                            flag = true;
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            // 인구 이동
            if (flag) {
                visited = new boolean[52][52];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (visited[i][j]) continue;
                        int sum = 0, cnt = 0;
                        Queue<Point> q = new LinkedList<>();
                        ArrayList<Point> arr = new ArrayList<>();
                        q.add(new Point(i, j));
                        arr.add(new Point(i,j));
                        visited[i][j] = true;
                        while (!q.isEmpty()) {
                            Point cur = q.poll();
                            sum += board[cur.x][cur.y];
                            cnt++;
                            for (int d = 0; d < 4; d++) {
                                int nx = cur.x + dx[d];
                                int ny = cur.y + dy[d];
                                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || union[nx][ny] == 0)
                                continue;
                                if (union[cur.x][cur.y] != union[nx][ny])
                                continue;
                                q.add(new Point(nx, ny));
                                arr.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                        int avg = sum / cnt;
                        for (Point p : arr) {
                            board[p.x][p.y] = avg;
                        }
                    }
                }
            }

            if (!flag)
                break;
            day++;
        }

        bw.write(day + "");
        bw.flush();
        bw.close();
    }
}