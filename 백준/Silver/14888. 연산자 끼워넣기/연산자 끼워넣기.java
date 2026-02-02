import java.io.*;
import java.util.*;
import java.awt.Point;;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
    static int[] nums = new int[102];
    static int[] op = new int[4];

    static void func(int k, int num) {
        if(k == n-1){
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }
        if(op[0] != 0){
            op[0]--;
            func(k+1, num + nums[k+1]);
            op[0]++;
        }
        if(op[1] != 0){
            op[1]--;
            func(k+1, num - nums[k+1]);
            op[1]++;
        }
        if(op[2] != 0){
            op[2]--;
            func(k+1, num * nums[k+1]);
            op[2]++;
        }
        if(op[3] != 0){
            op[3]--;
            func(k+1, num / nums[k+1]);
            op[3]++;
        }
        

    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        func(0,nums[0]);
        bw.write(mx+"\n");
        bw.write(mn+"");
        bw.flush();
        bw.close();
    }
}
