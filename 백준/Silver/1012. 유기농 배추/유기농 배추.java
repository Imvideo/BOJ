import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int m,n,k, cnt=0;
            boolean[][] visited = new boolean[52][52];
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[][] board = new int[52][52];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    if(board[i][j] == 0) continue;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    cnt++;
                    while(!q.isEmpty()){
                        Point cur = q.poll();
                        for(int d=0; d<4; d++){
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            if(board[nx][ny] == 0) continue;
                            q.add(new Point(nx,ny));
                        }
                    }
                }
            }
            bw.write(cnt+"\n");
            
        }

        bw.flush();
        bw.close();
    }
}