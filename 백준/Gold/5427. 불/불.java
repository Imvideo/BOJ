import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean tag = false;

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int num = 0;
            String map[][] = new String[h][w];
            int sg[][] = new int[h][w];
            int fire[][] = new int[h][w];
            Queue<Point> queue = new LinkedList<Point>();
            tag = false;

            //맵 초기화
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    Arrays.fill(sg[i],2000);
                    Arrays.fill(fire[i],2000);
                }
            }

            //맵 입력
            for(int i=0; i<h; i++){
                String line = br.readLine();
                String[] lines = line.split("");
                for(int j=0; j<w; j++){
                    map[i][j] = lines[j];
                }
            }

            //불 큐 추가
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j].equals("*")){
                        queue.add(new Point(i,j));
                        fire[i][j] = 0;
                    }
                }
            }

            //불 큐 돌리기
            while(!queue.isEmpty()){
                Point point = queue.poll();
                num = fire[point.x][point.y] + 1;
                for(int dir=0; dir<4; dir++){
                    int nx = point.x + dx[dir];
                    int ny = point.y + dy[dir];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(map[nx][ny].equals("#") || fire[nx][ny] != 2000) continue;
                    fire[nx][ny] = num;
                    queue.add(new Point(nx, ny));
                }
            }

            //상근이 큐 추가
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j].equals("@")){
                        if(i == 0 || i == h-1 || j == 0 || j == w-1){
                            num = 1;
                            tag = true;
                            bw.write(num+"\n");
                            break;
                        }
                        queue.add(new Point(i,j));
                        sg[i][j] = 0;
                    }
                }
            }

            //상근이 큐 돌리기
            while(!queue.isEmpty()){
                if(tag) break;
                Point point = queue.poll();
                num = sg[point.x][point.y] + 1;
                for(int dir=0; dir<4; dir++){
                    int nx = point.x + dx[dir];
                    int ny = point.y + dy[dir];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(!map[nx][ny].equals(".") || sg[nx][ny] != 2000) continue;
                    sg[nx][ny] = num;
                    if(sg[nx][ny] >= fire[nx][ny]) continue;
                    if(nx == 0 || nx == h-1 || ny == 0 || ny == w-1){
                        tag = true;
                        bw.write(++num+"\n");
                        break;
                    }
                    queue.add(new Point(nx, ny));
                }
            }
            if(!tag) bw.write("IMPOSSIBLE\n");

        }
        bw.flush();
        bw.close();
    }
}