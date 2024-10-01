import java.io.*;
import java.util.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] num = new int[15];
    static int[] arr = new int[8];
    static boolean[] isused = new boolean[15];
    static void func(int k) throws IOException{
        if(k==6){
            for(int i=0; i<6; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(!isused[i]){
                if(k!=0 && arr[k-1] > num[i]) continue;
                arr[k] = num[i];
                isused[i] = true;
                func(k+1);
                isused[i] = false;
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            for(int i=0; i<n; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num,0,n);
            func(0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}