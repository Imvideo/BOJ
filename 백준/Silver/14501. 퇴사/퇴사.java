import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] time = new int[17];
    static int[] pay = new int[17];
    static int[] ans = new int[17];
    public static void main(String args[]) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t, p;
            t = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            time[i] = t; pay[i] = p;
        }
        //
        for(int i=n-1; i>=0; i--){
            int a=0,b=ans[i+1];
            if(time[i] + i <= n){
                a = pay[i] + ans[i+time[i]];
            }
            ans[i] = Math.max(a,b);
        }
        bw.write(ans[0]+"");
        bw.flush();
        bw.close();
    }
}