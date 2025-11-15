import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int board[][] = new int[10][10];
    static int board2[][] = new int[10][10];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int n, m, mn = 0;
    static ArrayList<Point> cam = new ArrayList<>();
    
    static void func(int x, int y, int dir){
        int nx = x, ny = y;
        while(true){
            nx+=dx[dir]; ny+=dy[dir];
            if(nx < 0 || nx >=n || ny < 0 || ny >= m || board2[nx][ny] == 6) break;
            if(board2[nx][ny] != 0) continue;
            board2[nx][ny] = 7;
            
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num != 0 && num != 6) {
                    cam.add(new Point(i,j));
                }
                if(num == 0) mn++;
            }
        }
        for(int tmp=0; tmp<1<<(2*cam.size()); tmp++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    board2[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for(int i=0; i<cam.size(); i++){
                int dir = brute%4;
                brute /= 4;
                int nx = cam.get(i).x;
                int ny = cam.get(i).y;
                if(board[nx][ny] == 1){
                    func(nx, ny, dir);
                }
                else if(board[nx][ny] == 2){
                    func(nx, ny, dir);
                    func(nx, ny, (dir+2)%4);
                }
                else if(board[nx][ny] == 3){
                    func(nx, ny, dir);
                    func(nx, ny, (dir+1)%4);
                }
                else if(board[nx][ny] == 4){
                    func(nx, ny, dir);
                    func(nx, ny, (dir+1)%4);
                    func(nx, ny, (dir+2)%4);
                }
                else if(board[nx][ny] == 5){
                    func(nx, ny, dir);
                    func(nx, ny, (dir+1)%4);
                    func(nx, ny, (dir+2)%4);
                    func(nx, ny, (dir+3)%4);
                }

            }
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board2[i][j] == 0) cnt++;
                }
            }
            mn = Math.min(mn, cnt);
        }
        bw.write(mn+"");
        bw.flush();
        bw.close();
    }
}