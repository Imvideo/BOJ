import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m;
        int num = 0;
        int ans=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<Point>();
        int[][] map = new int[n][m];
        int[][] check = new int[n][m];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        //토마토 밭 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //거리 확인용 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], -1);
        }

        //익은 토마토 미리 큐에 넣기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    queue.add(new Point(i,j));
                    check[i][j] = 0;
                }
            }   
        }
        
        //큐 돌리기
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            num = check[point.x][point.y] + 1;
            for (int dir = 0; dir < 4; dir++) {
                int nx = point.x + dx[dir];
                int ny = point.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (check[nx][ny] != -1 || map[nx][ny] == -1)
                    continue;
                check[nx][ny] = num;
                queue.add(new Point(nx, ny));
                ans = Math.max(ans,check[nx][ny]);
            }
        }

        //익지 않은 토마토 확인
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check[i][j] == -1 && map[i][j] == 0){
                    ans = -1;
                }
            }   
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}
