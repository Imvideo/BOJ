import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m,ans=0;
    static List<Point> cctv = new ArrayList<Point>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean OOB(int a, int b){
        return a < 0 || a>=n || b<0 || b>=m;
    }
    
    static void upd(int x, int y, int dir){
        dir%=4;
        while(true){
            x+=dx[dir];
            y+=dy[dir];
            if(OOB(x,y) || board2[x][y] == 6) return;
            if(board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board1[i][j] = Integer.parseInt(st.nextToken());
                if(board1[i][j] != 0 && board1[i][j] != 6){
                    cctv.add(new Point(i,j));
                }
                if(board1[i][j] ==0) ans++;
            }
        }
        for(int tmp=0; tmp<(1<<(2*cctv.size()));tmp++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    board2[i][j] = board1[i][j];
                }
            }
            int brute = tmp;
            for(int i=0; i<cctv.size(); i++){
                int dir = brute % 4;
                brute /= 4;
                Point point = cctv.get(i);
                int x = point.x;
                int y = point.y;
                if(board1[x][y] == 1){
                    upd(x,y,dir);
                }
                else if(board1[x][y] == 2){
                    upd(x,y,dir);
                    upd(x,y,dir+2);
                }
                else if(board1[x][y] == 3){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                }
                else if(board1[x][y] == 4){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                }
                else if(board1[x][y] == 5){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                    upd(x,y,dir+3);
                }
            }
            int val = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board2[i][j] == 0) val++;
                }
            }
            ans = Math.min(val,ans);
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
}