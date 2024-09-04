import java.io.*;
import java.util.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n,m,year = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][] board2 = new int[n][m];
        int[][] dist = new int[n][m];
        //맵 입력
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }        

        while(true){
            Queue<Point> queue = new LinkedList<Point>();
            int area = 0;
            for(int i=0; i<n; i++){
                Arrays.fill(dist[i], -1);
                Arrays.fill(board2[i], 0);
            }
            //빙산 덩어리 계산
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board[i][j] != 0 && dist[i][j] == -1){
                        area++;
                        queue.add(new Point(i,j));
                        dist[i][j] = area;
                        while(!queue.isEmpty()){
                            Point point = queue.poll();
                            for(int dir=0; dir<4; dir++){
                                int nx = point.x + dx[dir];
                                int ny = point.y + dy[dir];
                                if(nx<=0 || nx>=n-1 || ny<=0 || ny>=m-1) continue;
                                if(board[nx][ny] == 0 || dist[nx][ny] != -1) continue;
                                dist[nx][ny] = area;
                                queue.add(new Point(nx,ny));
                            }
                        }
                    }

                }
            }

            if(area >= 2){
                bw.write(year+"");
                bw.flush();
                bw.close();
                System.exit(0);
            }

            if(area == 0){
                bw.write(0+"");
                bw.flush();
                bw.close();
                System.exit(0);
            }
            
            year++;

            //빙하 녹음 계산
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j] != 0){
                        int cnt = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if (board[nx][ny] == 0) {
                                cnt++;
                            }
                        }
                        board2[i][j] = board[i][j] - cnt;
                        if (board2[i][j] <= 0) {
                            board2[i][j] = 0;
                        }
                    }
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    board[i][j] = board2[i][j];
                }
            }
        }
        
    }
}