import java.io.*;
import java.util.*;
import java.awt.Point;;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, mx = 0, cnt = 0;
    static int[][] board = new int[10][10];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        int[][] board2 = new int[10][10];
        int ans = cnt - 3; // 벽 3개 세웠으므로 0개수 3개 뺴기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board2[i][j] = board[i][j];
                if(board2[i][j] == 2) {
                    q.add(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x, y = cur.y;
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board2[nx][ny] != 0) continue;
                board2[nx][ny] = 2;
                ans--;
                q.add(new Point(nx,ny));
            }
        }
        mx = Math.max(mx, ans);
    }
    static void func(int k) {
        if (k == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] != 0) continue;
                board[i][j] = 1;
                func(k+1);
                board[i][j] = 0;
                
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) cnt++;
            }
        }
        func(0);
        bw.write(mx+"");
        bw.flush();
        bw.close();
    }
}
