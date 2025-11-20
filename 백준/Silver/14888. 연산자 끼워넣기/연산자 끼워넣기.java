import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
    static int[] num = new int[12];
    static int[] op = new int[4];

    static void func(int k, int sum){
        if(k == N){
            mx = Math.max(mx, sum);
            mn = Math.min(mn, sum);
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i] == 0) continue;
            op[i]--;
            if(i == 0) func(k+1, sum + num[k]);
            else if(i == 1) func(k+1, sum - num[k]);
            else if(i == 2) func(k+1, sum * num[k]);
            else if(i == 3) func(k+1, sum / num[k]);
            op[i]++;
        }
    }
    public static void main(String args[]) throws IOException {
        // 입력
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        func(1,num[0]);
        bw.write(mx+"\n"+mn);
        bw.flush();
        bw.close();
    }
}