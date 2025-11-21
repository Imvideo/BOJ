import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] gear = new int[4][8];
    static int[] idx = new int[4];
    static int[] rot;
    static ArrayList<Point> arr = new ArrayList<>();
    static int k;

    static void rotate(int gearNum, int dir){ 
        //왼쪽으로 전파
        for(int i=gearNum; i>0; i--){
            int rightOfLeft = gear[i-1][idx[i-1]];
            int leftOfRight = gear[i][(idx[i]+4)%8];
            if(rightOfLeft == leftOfRight) break;
            rot[i-1] = -rot[i];
        }

        //오른쪽으로 전파
        for(int i=gearNum; i<3; i++){
            int rightOfLeft = gear[i][idx[i]];
            int leftOfRight = gear[i+1][(idx[i+1]+4)%8];
            if(rightOfLeft == leftOfRight) break;
            rot[i+1] = -rot[i];
        }

        //기어 회전
        for(int i=0; i<4; i++){
            idx[i] = (idx[i] -rot[i] + 8) % 8;
        }
    }
    public static void main(String args[]) throws IOException {
        // 입력
        for(int i=0; i<4; i++){
            String line = br.readLine();
            idx[i] = 2;
            for(int j=0; j<8; j++){
                gear[i][j] = line.charAt(j)-'0';

            }
        }
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x,y));
        }
        // 작업 수행
        for(int i=0; i<arr.size(); i++){
            int gearNum = arr.get(i).x-1;
            int dir = arr.get(i).y;
            rot = new int[4];
            rot[gearNum] = dir;
            rotate(gearNum, dir);
            
        }
        //점수 합산
        int sum = 0;
        for(int i=0; i<4; i++){
            if(gear[i][(idx[i]+6)%8] == 1){
                sum += (1<<i);
            }
        }
        
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}