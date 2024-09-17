import java.io.*;
import java.util.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];

    static void func(int k) throws IOException{
        if(k == m){
            for(int i=0; i<m; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                func(k+1);
                isused[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        bw.flush();
        bw.close();
    }
}