import java.io.*;
import java.util.*;
import java.awt.Point;

class Tuple{
    int x, y, z;
    Tuple(int x, int y, int z){
        this.x = x; this.y = y; this.z = z;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][][][] board = new int[4][5][5][5];
    static int[][][] maze = new int[5][5][5];
    static int[] order = new int[5];
    static boolean[] picked = new boolean[5];
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static int mn = 9999;

    static int bfs(){
        if(maze[0][0][0] == 0 || maze[4][4][4] == 0) return 9999;
        int[][][] dis = new int[5][5][5];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, 0));
        dis[0][0][0] = 1;
        while(!q.isEmpty()){
            Tuple cur = q.poll();
            for(int d=0; d<6; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
                if(maze[nx][ny][nz] == 0 || dis[nx][ny][nz] != 0) continue;
                if(nx == 4 && ny == 4 && nz == 4) {
                    return dis[cur.x][cur.y][cur.z];
                }
                dis[nx][ny][nz] = dis[cur.x][cur.y][cur.z] + 1;
                q.add(new Tuple(nx, ny, nz));
            }
        }
        return 9999;
    }
    static void solve(){
        for(int tmp=0; tmp < 1024; tmp++){
            int brute = tmp;
            for(int i=0; i<5; i++){
                int dir = brute % 4;
                brute /= 4;
                for(int j=0; j<5; j++){
                    for(int k=0; k<5; k++){
                        maze[i][j][k] = board[dir][order[i]][j][k];
                    }
                }
            }
            mn = Math.min(mn, bfs());
        }
    }
    static void func(int k){
        if(k == 5){
            solve();
            return;
        }
        for(int i=0; i<5; i++){
            if(picked[i]) continue;
            picked[i] = true;
            order[k] = i;
            func(k+1);
            picked[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<5; k++){
                    board[0][i][j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    board[1][i][j][k] = board[0][i][4-k][j];
                }
            }

            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    board[2][i][j][k] = board[1][i][4-k][j];
                }
            }

            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    board[3][i][j][k] = board[2][i][4-k][j];
                }
            }
        }
        func(0);
        if(mn == 9999) bw.write("-1");
        else bw.write(mn+"");
        bw.flush();
        bw.close();
    }
}