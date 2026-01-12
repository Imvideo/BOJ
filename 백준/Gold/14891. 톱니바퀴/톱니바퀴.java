import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k;
    static int[][] gear = new int[4][8];

    static void go(int x, int dir){
        int[] dirs = new int[4];
        dirs[x] = dir;
        int idx = x;
        while(idx > 0 && gear[idx][6] != gear[idx-1][2]){
            dirs[idx-1] = -dirs[idx];
            idx--;
        }

        idx = x;
        while(idx < 3 && gear[idx][2] != gear[idx+1][6]){
            dirs[idx+1] = -dirs[idx];
            idx++;
        }

        for(int i=0; i<4; i++){
            if(dirs[i] == 0)  continue;
            rotate(i,dirs[i]);
        }
    }

    static void rotate(int x, int dir){
        int[] tmp = new int[8];
        for(int i=0; i<8; i++){
            tmp[i] = gear[x][i];
        }
        if(dir == -1){
            for(int i=0; i<8; i++){
                gear[x][i] = tmp[(i+1)%8];
            }
        }
        else{
            for(int i=0; i<8; i++){
                gear[x][i] = tmp[(i+7)%8];
            }
        }
    }

    static int cal() {
        int score = 0;
        for(int i=0; i<4; i++){
            if(gear[i][0] == 1){
                score += (1 << i);
            }
        }
        return score;
    }
    public static void main(String[] args) throws IOException {
        for(int i=0; i<4; i++){
            String line = br.readLine();
            for(int j=0; j<8; j++){
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            go(n-1,dir);
        }
        bw.write(cal()+"");
        bw.flush();
        bw.close();
    }
}