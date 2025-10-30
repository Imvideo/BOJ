import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int n, cnt=0;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static char[][] board = new char[26][26];
    static boolean[][] visited = new boolean[25][25];
    static int[] ans = new int[1000];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;
                if(board[i][j] == '0') continue;
                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i,j));
                visited[i][j] = true;
                int num = 1;
                while(!q.isEmpty()){
                    Point cur = q.poll();
                    for(int d=0; d<4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if(nx < 0 || nx >=n || ny < 0 || ny >= n) continue;
                        if(visited[nx][ny]) continue;
                        if(board[nx][ny] == '0'){
                            visited[nx][ny] = true;
                            continue;
                        }
                        num++;
                        q.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
                ans[cnt] = num;
                cnt++;
            }
        }
        bw.write(cnt+"\n");
        Arrays.sort(ans,0,cnt);
        for(int i=0; i<cnt; i++){
            bw.write(ans[i]+"\n");
        }

        bw.flush();
        bw.close();
    }
}