import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int k,hDir, wDir,mxW, mxH, mnW, mnH, ans;
    static ArrayList<Point> board = new ArrayList<>();
    static int dirCnt[] = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir, len;
            dir = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            board.add(new Point(dir, len));
            dirCnt[dir]++;
            if(dirCnt[dir]==2){
                if(dir==1 || dir == 2) wDir = dir;
                else hDir = dir;
            }
            
        }
        for(int i=0; i<6; i++){
            int tmpDir = board.get(i).x;
            if(tmpDir == wDir){
                int pre, pos;
                pre = board.get((i-1+6)%6).x;
                pos = board.get((i+1)%6).x;
                if(pre == hDir && pos == hDir) mnW = board.get(i).y;
            }
            else if(tmpDir == hDir){
                int pre, pos;
                pre = board.get((i-1+6)%6).x;
                pos = board.get((i+1)%6).x;
                if(pre == wDir && pos == wDir) mnH = board.get(i).y;
            }
            else{
                if(tmpDir == 1 || tmpDir == 2) mxW = board.get(i).y;
                else if(tmpDir == 3 || tmpDir == 4) mxH = board.get(i).y;
            }
        }
        ans = (mxH * mxW - mnH * mnW) * k;
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}