import java.io.*;
import java.util.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,cnt = 0;
    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];

    static void func(int cur){
        if(cur == n){
            cnt++;
            return;
        }
        for(int i=0; i<n; i++){
            if(isused1[i] || isused2[i+cur] || isused3[cur-i+n-1]){
                continue;
            }
            isused1[i] = true;
            isused2[i+cur] = true;
            isused3[cur-i+n-1] = true;
            func(cur+1);
            isused1[i] = false;
            isused2[i+cur] = false;
            isused3[cur-i+n-1] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        func(0);
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}