import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int board[][] = new int[102][102];
    static boolean visited[][] = new boolean[102][102];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static class State{
        int r, c, dir;
        State(int r, int c, int dir){
            this.r = r; this.c = c; this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, k, l, t=0, r=0, c=0, dir=1;
        boolean flag = false;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        visited[0][0] = true;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row, col;
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            board[row-1][col-1] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=0; char com;
            x = Integer.parseInt(st.nextToken());
            com = st.nextToken().charAt(0);
            int move = x - t;
            if(flag) continue;
            for(int j=0; j<move; j++){
                t++;
                int nx = r + dx[dir];
                int ny = c + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]){
                    flag = true;
                    break;
                }
                q.add(new Point(nx,ny));
                visited[nx][ny] = true;
                r = nx; c = ny;
                if(board[nx][ny] == 1){    
                    board[nx][ny] = 0;
                }
                else{
                    Point cur = q.poll();
                    visited[cur.x][cur.y] = false;
                }
            }
            if(com == 'L') dir = (dir+3)%4;
            else dir = (dir+1)%4;
        }
        while(!flag){
            t++;
                int nx = r + dx[dir];
                int ny = c + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]){
                    flag = true;
                    break;
                }
                q.add(new Point(nx,ny));
                visited[nx][ny] = true;
                r = nx; c = ny;
                if(board[nx][ny] == 1){    
                    board[nx][ny] = 0;
                }
                else{
                    Point cur = q.poll();
                    visited[cur.x][cur.y] = false;
                }
        }
        bw.write(t+"");
        bw.flush();
        bw.close();
    }
}