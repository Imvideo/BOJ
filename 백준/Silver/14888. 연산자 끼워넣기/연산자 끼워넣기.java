import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, mx = -1000000001, mn = 1000000001, opCnt = 0;
    static int[] arr = new int[12];
    static int[] op = new int[4];

    static void func(int k, int sum){
        if(k == n-1){
            mx = Math.max(mx, sum);
            mn = Math.min(mn, sum);
            return;
        }
        for(int i=0; i< 4; i++){
            if(op[i] > 0){
                op[i]--;
                if(i == 0) func(k+1, sum + arr[k+1]);
                else if(i == 1) func(k+1, sum - arr[k+1]);
                else if(i == 2) func(k+1, sum * arr[k+1]);
                else if(i == 3) func(k+1, sum / arr[k+1]);
                op[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
            opCnt += op[i];
        }
        func(0, arr[0]);
        bw.write(mx + "\n" + mn);
        bw.flush();
        bw.close();
    }
}