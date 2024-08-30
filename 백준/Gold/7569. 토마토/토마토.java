import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int x,y,z;
        public Node(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int day = 0;
        int[][][] map = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        for(int i=0;i<h;i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dist[i][j], -1);
            }
        }
        //토마토 맵 입력
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Queue<Node> queue = new LinkedList<Node>();
        
        // 익은 토마토 넣기
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] != 1) continue;
                    dist[i][j][k] = day;
                    queue.add(new Node(i,j,k));
                }
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            day = dist[node.z][node.y][node.x]+1;
            for(int dir=0; dir<6; dir++){
                int nx = node.x + dx[dir];
                int ny = node.y + dy[dir];
                int nz = node.z + dz[dir];
                if(nx < 0 || nx >=m || ny < 0 || ny >=n || nz < 0 || nz >=h) continue;
                if(map[nz][ny][nx] == -1 || dist[nz][ny][nx] != -1) continue;
                dist[nz][ny][nx] = day;
                queue.add(new Node(nz, ny, nx));
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 0 && dist[i][j][k] == -1){
                        bw.write(-1+"");
                        bw.flush();
                        bw.close();
                        System.exit(0);
                    }
                    
                }
            }
        }

        bw.write(day-1+"");
        bw.flush();
        bw.close();
        
    }
}