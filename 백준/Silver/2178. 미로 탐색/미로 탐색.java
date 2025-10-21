import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    
    static class State{
        int x, y, cnt;
        State(int x, int y, int cnt){
            this.x = x; this.y = y; this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char board[][] = new char[102][102];
        boolean visited[][] = new boolean[102][102];
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j);
            }
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(0,0,1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            State cur = q.poll();
            for(int d=0; d<4; d++){
                int x = cur.x + dx[d];
                int y = cur.y + dy[d];
                if(x < 0 || x>=n || y<0 || y>=m) continue;
                if(board[x][y] == '0' || visited[x][y]) continue;
                visited[x][y] = true;
                if(x==n-1 && y == m-1){
                    bw.write(cur.cnt+1 +"");
                    break;
                }
                q.add(new State(x, y, cur.cnt+1));
            }
            

        }
        bw.flush();
        bw.close();
    }
}