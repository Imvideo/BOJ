import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int[][] gear = new int[4][8];
    static int[] idx = {2, 2, 2, 2};
    static int[] rot = new int[4];
    static int k;
    
    static void rotate(int num, int dir){
        //left
        for(int i=num-1; i > 0; i--){
            int rigthIdxofleft = idx[i-1];
            int leftIdxofrigth = (idx[i] + 4) % 8;
            if(gear[i][leftIdxofrigth] != gear[i-1][rigthIdxofleft]){
                rot[i-1] = -rot[i];
            }
            else break;
        }
        //right
        for(int i=num-1; i<3; i++){
            int rigthIdxofleft = idx[i];
            int leftIdxofrigth = (idx[i+1] + 4) % 8;
            if(gear[i][rigthIdxofleft] != gear[i+1][leftIdxofrigth]){
                rot[i+1] = -rot[i];
            }
            else break;
        }
        for(int i=0; i<4; i++){
            idx[i] = (idx[i] - rot[i] + 8) % 8;
        }
    }
    public static void main(String[] args) throws IOException {
        for(int i=0; i<4; i++){
            String line = br.readLine();
            for(int j=0; j<8; j++){
                gear[i][j] = line.charAt(j)-'0';
            }
        }
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            rot = new int[4];
            int num, dir;
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            rot[num-1] = dir;
            rotate(num, dir);

        }
        int sum = 0;
        for(int i=0; i<4; i++){
            if(gear[i][(idx[i]+6)%8] == 1){
                sum += 1 << i;
            }
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}