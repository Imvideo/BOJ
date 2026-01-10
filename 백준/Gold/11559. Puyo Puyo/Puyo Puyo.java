import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int cnt = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[][] board = new char[15][8];
    static boolean[][] visited;

    static boolean puyo() throws IOException{
        visited = new boolean[15][8];
        boolean flag = false;
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++) {
                if (board[i][j] != '.' && !visited[i][j]) {
                    if(bfs(i,j)) {
                        flag = true;
                        down();
                    }
                }
            }
        }

        
        if(flag) {
            cnt++;
            return true;
        }
        else return false;
    }

    static void down() {
        for(int i=0; i<6; i++) {
            ArrayList<Character> arr = new ArrayList<>();
            for(int j=11; j>=0; j--) {
                if(board[j][i] != '.') {
                    arr.add(board[j][i]);
                    board[j][i] = '.';
                }
            }            
            for(int j=0; j<arr.size(); j++) {
                board[11-j][i] = arr.get(j);
            }
        }

    }
    static boolean bfs(int x, int y) throws IOException{
        char block = board[x][y];
        visited[x][y] = true;
        ArrayList<Point> arr = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        arr.add(new Point(x,y));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if(board[nx][ny] != block || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
                arr.add(new Point(nx, ny));
            }
        }
        if(arr.size() >= 4) {
            for(int i=0; i<arr.size(); i++) {
                int r = arr.get(i).x;
                int c = arr.get(i).y;
                board[r][c] = '.';
            }
            return true;
        }
        // for(int i=0; i<12; i++) {
        //     for(int j=0; j<6; j++) {
        //         bw.write(board[i][j]+" ");
        //     }
        //     bw.write("\n");
        // }
        // bw.write("------------------\n");
        return false;
    }
    public static void main(String[] args) throws IOException{
        for(int i=0; i<12; i++) {
            String line = br.readLine();
            for(int j=0; j<6; j++) {
                board[i][j] = line.charAt(j);
            }
        }    
        while(puyo()) {}
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}