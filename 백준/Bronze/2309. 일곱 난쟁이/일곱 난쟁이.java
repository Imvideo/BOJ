import java.io.*;
import java.util.*;
public class Main{
    static int ans[] = new int[9];
    static int arr[] = new int[9];
    static boolean isused[] = new boolean[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException{
        if(k==7){
            int sum=0;
            for(int i=0; i<7; i++){
                sum+=ans[i];
            }
            if(sum == 100){
                for(int i=0; i<7; i++){
                    bw.write(ans[i]+"\n");
                }
                bw.flush();
                bw.close();
                System.exit(0);
            }
            else{
                return;
            }
        }
        for(int i=0; i<9; i++){
            if(!isused[i]){
                ans[k] = arr[i];
                isused[i] = true;
                func(k+1);
                isused[i] = false;
            }
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        func(0);
        bw.flush();
        bw.close();

        
    }
}