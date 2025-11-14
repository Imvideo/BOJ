import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int board[][] = new int[1002][1002];
    static boolean visited[][] = new boolean[1002][1002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num == 1){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int d=0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny] || board[nx][ny] != 0) continue;
                visited[nx][ny] = true; board[nx][ny] = board[cur.x][cur.y] + 1;
                q.add(new Point(nx,ny));

            }
        }
        int mx = 0; boolean flag = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    flag = true;
                    break;
                }
                mx = Math.max(mx, board[i][j]);
            }
            if(flag) break;
        }
        if(flag){
            bw.write(-1+"");
        }
        else{
            bw.write(mx-1+"");
        }

        bw.flush();
        bw.close();
    }
}