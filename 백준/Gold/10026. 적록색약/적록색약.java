import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        int[][] normalMap = new int[n][n];
        int[][] blindMap = new int[n][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int area = 0;
        String tag = "R";

        for(int i=0;i<n;i++){
            Arrays.fill(normalMap[i],-1);
            Arrays.fill(blindMap[i],-1);
        }
        for(int i = 0; i<n; i++){
            String line = br.readLine();
            String[] lines = line.split("");
            for(int j=0; j<n; j++){
                map[i][j] = lines[j];
            }
        }

        //정상인이 봤을 때
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(normalMap[i][j] != -1) continue;
                area++;
                if(map[i][j].equals("R")) {
                    normalMap[i][j] = 0;
                    tag = "R";
                }
                if(map[i][j].equals("G")) {
                    normalMap[i][j] = 1;
                    tag = "G";
                }
                if(map[i][j].equals("B")) {
                    normalMap[i][j] = 2;
                    tag = "B";
                }
                Queue<Point> queue = new LinkedList<Point>();
                queue.add(new Point(i,j));
                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    for(int k=0;k<4;k++){
                        int nx = point.x + dx[k];
                        int ny = point.y + dy[k];
                        if(nx<0 || nx >= n || ny<0 || ny >= n) continue;
                        if(!map[nx][ny].equals(tag)) continue;
                        if(normalMap[nx][ny] != -1) continue;
                        queue.add(new Point(nx,ny));
                        normalMap[nx][ny] = 0;
                    }
                    
                }
            }
        }
        bw.write(area+" ");

        area = 0;
        //색맹이 봤을 때
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(blindMap[i][j] != -1) continue;
                area++;
                if(map[i][j].equals("R") || map[i][j].equals("G")) {
                    blindMap[i][j] = 0;
                    tag = "R";
                }
                if(map[i][j].equals("B")) {
                    blindMap[i][j] = 2;
                    tag = "B";
                }
                Queue<Point> queue = new LinkedList<Point>();
                queue.add(new Point(i,j));
                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    for(int k=0;k<4;k++){
                        int nx = point.x + dx[k];
                        int ny = point.y + dy[k];
                        if(nx<0 || nx >= n || ny<0 || ny >= n) continue;
                        if(tag.equals("R") && map[nx][ny].equals("B")) continue;
                        if(tag.equals("B") && (map[nx][ny].equals("R") ||map[nx][ny].equals("G")) ) continue;
                        if(blindMap[nx][ny] != -1) continue;
                        queue.add(new Point(nx,ny));
                        blindMap[nx][ny] = 0;
                    }
                    
                }
            }
        }
        bw.write(area+"");
        bw.flush();
        bw.close();
    }
}