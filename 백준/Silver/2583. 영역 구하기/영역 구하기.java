import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int board[][] = new int[102][102];
    static int ans[] = new int[5002];
    static boolean visited[][] = new boolean[102][102];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
       int m, n, k, cnt=0;
       StringTokenizer st = new StringTokenizer(br.readLine());
       m = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());
       k = Integer.parseInt(st.nextToken());

       for(int i=0; i<k; i++){
        int x1, y1, x2, y2;
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        for(int x=x1; x<x2; x++){
            for(int y=y1; y<y2; y++){
                board[y][x] = 1;
            }
        }
       }

       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            int num=1;
            if(board[i][j] == 0 && !visited[i][j]){
                visited[i][j] = true;
                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i,j));
                while(!q.isEmpty()){
                    Point cur = q.poll();
                    for(int d=0; d<4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if(board[nx][ny] == 1 || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        num++;
                        q.add(new Point(nx, ny));
                    }
                }
                ans[cnt++] = num;
            }
        }
       }
       Arrays.sort(ans,0,cnt);
       bw.write(cnt+"\n");
       for(int i=0; i<cnt; i++){
        bw.write(ans[i]+" ");

       }
    //    bw.write("\n");
    //    for(int i=0; i<m; i++){
    //     for(int j=0; j<n; j++){
    //         bw.write(board[i][j]+" ");
    //     }
    //     bw.write("\n");
    //    }

        bw.flush();
        bw.close();
    }
}