import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static class State{
        int r, c, dir;
        State(int r, int c, int d){
            this.r = r; this.c = c; this.dir = d;
        }
    }
    static int cnt=0;
    static int board[][] = new int[52][52];
    static boolean visited[][] = new boolean[52][52];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m, r, c, dir;
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
        Queue<State> q = new LinkedList<>();
        q.add(new State(r, c, dir));

        while(!q.isEmpty()){
            State cur = q.poll();
            boolean flag = false;
            if(board[cur.r][cur.c] == 0 && !visited[cur.r][cur.c]){
                visited[cur.r][cur.c] = true;
                cnt++;
            }
            for(int d=0; d<4; d++){
                int nx = cur.r + dx[d];
                int ny = cur.c + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny] || board[nx][ny] == 1) continue;
                flag = true;
            }
            if(!flag) {
                int nx = cur.r + dx[cur.dir];
                int ny = cur.c + dy[cur.dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1) break;
                q.add(new State(nx, ny, cur.dir));
            }
            else{
                for(int i=0; i<4; i++){
                int tmpDir = (cur.dir+3*(i+1))%4;
                int nx = cur.r + dx[(tmpDir+2)%4];
                int ny = cur.c + dy[(tmpDir+2)%4];
                if(board[nx][ny] == 0 && !visited[nx][ny]){
                    q.add(new State(nx, ny, tmpDir));
                    break;
                }
            }
            }
            
            
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}