import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, m, r, c, dir, cnt = 0;
    static int[][] board = new int[52][52];
    static boolean[][] visited = new boolean[52][52];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<State> q = new LinkedList<>();
    static class State{
        int r, c, dir;
        State(int r, int c, int dir){
            this.r = r; this.c = c; this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        q.add(new State(r, c, dir));
        while(!q.isEmpty()){
            boolean cleaned = true;
            State cur = q.poll();
            if(!visited[cur.r][cur.c]) {
                visited[cur.r][cur.c] = true;
                cnt++;
            }
            for(int d=0; d<4; d++){
                int nx = cur.r + dx[d];
                int ny = cur.c + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1) continue;
                if(visited[nx][ny]) continue;
                cleaned = false;
            }
            if(cleaned){
                int nx = cur.r + dx[(cur.dir+2)%4];
                int ny = cur.c + dy[(cur.dir+2)%4];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1) break;
                q.add(new State(nx, ny, cur.dir));
            }
            else{
                int tmp = cur.dir;
                for(int d=0; d<4; d++){
                    tmp = (tmp + 3) % 4;
                    int nx = cur.r + dx[tmp];
                    int ny = cur.c + dy[tmp];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1) continue;
                    if(visited[nx][ny]) continue;
                    q.add(new State(nx, ny, tmp));
                    break;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}