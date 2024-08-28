import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T, n, m, num, area;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            int[][] dist = new int[n][m];
            
            for(int x = 0 ; x < n ; x++){
                Arrays.fill(map[x], 0);
                Arrays.fill(dist[x], -1);
            }

            num = Integer.parseInt(st.nextToken());
            area = 0;

            for(int x = 0; x < num; x++){ // 배추 위치 입력
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            Queue<Point> queue = new LinkedList<Point>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 0 || dist[i][j] != -1) continue;
                    area++;
                    dist[i][j] = 0;
                    queue.add(new Point(i,j));
                    while(!queue.isEmpty()){
                        Point point = queue.poll();
                        for(int k = 0; k<4; k++){
                            int nx = point.x + dx[k];
                            int ny = point.y + dy[k];
                            if(nx < 0 || nx >=n || ny <0 || ny >=m) continue;
                            if(map[nx][ny] != 1 || dist[nx][ny] != -1) continue;
                            dist[nx][ny] = 0;
                            queue.add(new Point(nx,ny));
                        }
                    }
                }
            }

            bw.write(area+"\n");

        }
        bw.flush();
        bw.close();
    }
}