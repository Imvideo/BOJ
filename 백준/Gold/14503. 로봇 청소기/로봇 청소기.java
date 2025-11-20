import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, r, c, dir, cnt = 0;
    static boolean flag = false;
    static int[][] board = new int[52][52];
    static boolean[][] visit = new boolean[52][52];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static boolean OOB(int nx, int ny){
        if(nx < 0 || nx >=n || ny < 0 || ny >= m) return true;
        return false;
    }
    public static void main(String args[]) throws IOException {
        // 입력
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
        // 
        while(true){
            flag = false;
            if(!visit[r][c]) {
                visit[r][c] = true; // 1. 현재칸 청소;
                cnt++;
            }
            
            for(int d=0; d<4; d++){
                int nx = r + dx[d];
                int ny = c + dy[d];
                if(OOB(nx, ny) || board[nx][ny] == 1 || visit[nx][ny]) continue;
                flag = true;
            }
            if(!flag){ // 4방향에 청소할 곳 없음
                int nx = r + dx[(dir+2)%4];
                int ny = c + dy[(dir+2)%4];
                if(OOB(nx, ny) || board[nx][ny] == 1) break;
                r = nx; c = ny;
            }
            else{ // 4방향에 청소할 곳 있음
                for(int d=0; d<4; d++){
                    dir = (dir+3) %4;
                    int nx = r + dx[dir];
                    int ny = c + dy[dir];
                    if(OOB(nx, ny) || board[nx][ny] == 1 || visit[nx][ny]) continue;
                    r = nx;
                    c = ny;
                    break;
                
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}